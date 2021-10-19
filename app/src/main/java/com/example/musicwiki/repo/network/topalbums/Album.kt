package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Album (
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

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