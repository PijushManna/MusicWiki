package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.lang.StringBuilder

data class Artist(
    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("playcount")
    @Expose
    val playcount: String? = null,

    @SerializedName("listeners")
    @Expose
    val listeners: String? = null,

    @SerializedName("mbid")
    @Expose
    val mbid: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("streamable")
    @Expose
    val streamable: String? = null,

    @SerializedName("image")
    @Expose
    val image: List<Image>? = null
)