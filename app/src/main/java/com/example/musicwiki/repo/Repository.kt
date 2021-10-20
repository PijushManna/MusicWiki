package com.example.musicwiki.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.musicwiki.repo.local.albums.Albums
import com.example.musicwiki.repo.local.albums.AlbumsDAO
import com.example.musicwiki.repo.local.albums.AlbumsDatabase
import com.example.musicwiki.repo.local.artists.Artists
import com.example.musicwiki.repo.local.artists.ArtistsDAO
import com.example.musicwiki.repo.local.artists.ArtistsDatabase
import com.example.musicwiki.repo.local.genre.Genre
import com.example.musicwiki.repo.local.genre.GenreDAO
import com.example.musicwiki.repo.local.genre.GenreDatabase
import com.example.musicwiki.repo.local.tracks.Tracks
import com.example.musicwiki.repo.local.tracks.TracksDAO
import com.example.musicwiki.repo.local.tracks.TracksDatabase
import com.example.musicwiki.repo.network.albumsinfo.AlbumsInfo
import com.example.musicwiki.repo.network.genreinfo.TagInfo
import com.example.musicwiki.repo.network.topalbums.TopAlbums
import com.example.musicwiki.repo.network.topartists.NetworkArtists
import com.example.musicwiki.repo.network.topgenre.TopTagInfo
import com.example.musicwiki.repo.network.toptracks.NetworkTracks
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Repository {
    private const val TAG = "REPOSITORY"
    private const val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
    private const val API_KEY = "8bfe4bd8ae71bd4dda4b58cc138e1035"
    private const val FORMAT = "json"
    private lateinit var genreDatabase: GenreDAO
    private lateinit var albumsDatabase: AlbumsDAO
    private lateinit var artistsDatabase: ArtistsDAO
    private lateinit var tracksDatabase: TracksDAO
    private lateinit var requestQueue: RequestQueue
    private val gson = GsonBuilder().create()

    fun init(context: Context) {
        genreDatabase = GenreDatabase.getInstance(context).genreDAO
        albumsDatabase = AlbumsDatabase.getInstance(context).albumsDAO
        artistsDatabase = ArtistsDatabase.getInstance(context).artistsDAO
        tracksDatabase = TracksDatabase.getInstance(context).tracksDAO
        requestQueue = Volley.newRequestQueue(context)
        CoroutineScope(Dispatchers.Default).launch {
            genreDatabase.getCount().apply {
                if (this == 0) {
                    fetchGenreFromNetwork()
                }
            }
        }
    }

    /* ---- Fetch Genre ---- */
    private fun fetchGenreFromNetwork() {
        val url = "$BASE_URL?method=tag.getTopTags&api_key=$API_KEY&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, TopTagInfo::class.java)
                res.toptags.tag.toSet().forEach {
                    if (it.name != null) {
                        genreDatabase.insert(
                            Genre(
                                name = it.name!!,
                                count = it.count,
                                reach = it.reach
                            )
                        )
                    }
                }
            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
    }

    fun fetchGenreInfo(item: Genre): LiveData<Genre> {
        val url = "$BASE_URL?method=tag.getinfo&tag=${item.name}&api_key=$API_KEY&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, TagInfo::class.java)
                item.content = res.tag?.wiki?.content
                item.summery = res.tag?.wiki?.summary
                genreDatabase.update(item)
            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
        return genreDatabase.getItemById(item.id)
    }

    fun getShortGenre(): LiveData<List<Genre>> {
        return genreDatabase.getData(10)
    }

    fun getAllGenre(): LiveData<List<Genre>> {
        return genreDatabase.getAllData()
    }

    /* ----- Fetch Top Albums ----- */
    fun fetchAlbumInfo(item:Albums): LiveData<Albums> {
        val url = "$BASE_URL?method=album.getinfo&api_key=$API_KEY&artist=${item.artist}&album=${item.name}&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, AlbumsInfo::class.java)
                res.album.apply {
                    item.artist = artist
                    item.mbid = mbid
                    item.playCount = playcount
                    item.image = image?.get(3)?.text
                    item.listeners = listeners
                    item.published = wiki.published
                    item.summery = wiki.summary
                    item.content = wiki.content
                }
                albumsDatabase.update(item)
            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
        return albumsDatabase.getAlbumById(item.id)
    }

    fun fetchAlbums(tag: String): LiveData<List<Albums>> {
        CoroutineScope(Dispatchers.Default).launch {
            albumsDatabase.getCount(tag).apply {
                if (this == 0) {
                    fetchAlbumsFromNetwork(tag)
                }
            }
        }
        return albumsDatabase.getAlbumsByTag(tag)
    }

    private fun fetchAlbumsFromNetwork(tag: String) {
        val url = "$BASE_URL?method=tag.gettopalbums&tag=$tag&api_key=$API_KEY&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, TopAlbums::class.java)
                var name: String?
                var mbid: String?
                var url: String?
                var artist: String?
                var image: String?
                var ranking: String?
                res.albums?.album?.forEach {
                    name = it.name
                    mbid = it.mbid
                    url = it.url
                    artist = it.artist?.name
                    image = it.image?.get(3)?.text
                    ranking = it.attr?.rank

                    if (name != null) {
                        val album = Albums(
                            name = name,
                            tag = tag,
                            mbid = mbid,
                            url = url,
                            artist = artist,
                            image = image,
                            rank = ranking
                        )
                        albumsDatabase.insert(album)
                    }
                }

            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
    }

    /* ---- Fetch Top Artists ----- */
    fun fetchArtists(tag: String): LiveData<List<Artists>> {
        CoroutineScope(Dispatchers.Default).launch {
            artistsDatabase.getCount(tag).apply {
                if (this == 0) {
                    fetchTopArtistsFromNetwork(tag)
                }
            }
        }
        return artistsDatabase.getArtistsByTag(tag)
    }

    private fun fetchTopArtistsFromNetwork(tag: String) {
        val url = "$BASE_URL?method=tag.gettopartists&tag=$tag&api_key=$API_KEY&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, NetworkArtists::class.java)
                var name: String?
                var mbid: String?
                var url: String?
                var image: String?
                var ranking: String?
                res.topartists?.artist?.forEach {
                    name = it.name
                    mbid = it.mbid
                    url = it.url
                    image = it.image?.get(3)?.text
                    ranking = it.attr?.rank

                    if (name != null) {
                        val artist = Artists(
                            name = name,
                            tag = tag,
                            mbid = mbid,
                            url = url,
                            image = image,
                            rank = ranking
                        )
                        artistsDatabase.insert(artist)
                    }
                }

            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
    }

    /* ---- Fetch Top Tracks ---- */
    fun fetchTracks(tag: String): LiveData<List<Tracks>> {
        CoroutineScope(Dispatchers.Default).launch {
            tracksDatabase.getCount(tag).apply {
                if (this == 0) {
                    fetchTopTracksFromNetwork(tag)
                }
            }
        }
        return tracksDatabase.getItemsByTag(tag)
    }

    private fun fetchTopTracksFromNetwork(tag: String) {
        val url = "$BASE_URL?method=tag.gettoptracks&tag=$tag&api_key=$API_KEY&format=$FORMAT"
        val request = StringRequest(url, { it ->
            CoroutineScope(Dispatchers.IO).launch {
                val res = gson.fromJson(it, NetworkTracks::class.java)
                var name: String?
                var duration: String?
                var mbid: String?
                var url: String?
                var streamable: String?
                var artist: String?
                var image: String?
                var rank: String?

                res.tracks?.track?.forEach { it ->
                    name = it.name
                    duration = it.duration
                    mbid = it.mbid
                    url = it.url
                    artist =it.artist?.name
                    image = it.image?.get(3)?.text
                    rank = it.attr?.rank

                    if (name!= null){
                        val track = Tracks(
                            name = name,
                            tag = tag,
                            duration = duration,
                            mbid = mbid,
                            url = url,
                            artist = artist,
                            image = image,
                            rank = rank
                        )
                        tracksDatabase.insert(track)
                    }
                }
            }
        }, {
            Log.e(TAG, it.localizedMessage!!)
        })
        requestQueue.add(request)
    }
}