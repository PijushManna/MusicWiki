package com.example.musicwiki.repo.local.tracks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicwiki.repo.network.toptracks.Artist
import com.example.musicwiki.repo.network.toptracks.Attr
import com.example.musicwiki.repo.network.toptracks.Image
import com.example.musicwiki.repo.network.toptracks.Streamable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tracks")
data class Tracks  (
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("duration")
    @Expose
    var duration: String? = null,

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("streamable")
    @Expose
    var streamable: Streamable? = null,

    @SerializedName("artist")
    @Expose
    var artist: Artist? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null,

    @SerializedName("@attr")
    @Expose
    var rank: String? = null
)