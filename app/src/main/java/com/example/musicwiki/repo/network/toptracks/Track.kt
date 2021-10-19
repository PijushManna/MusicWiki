package com.example.musicwiki.repo.network.toptracks

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.musicwiki.repo.network.toptracks.Streamable

data class Track(
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
    var image: List<Image>? = null,

    @SerializedName("@attr")
    @Expose
    var attr: Attr? = null
)