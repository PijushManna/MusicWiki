package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.musicwiki.repo.network.topalbums.Album
import com.example.musicwiki.repo.network.topalbums.Attr__1

data class NetworkAlbums(
    @SerializedName("album")
    @Expose
    var album: List<Album>? = null,

    @SerializedName("@attr")
    @Expose
    var attr: Attr__1? = null
)