package com.example.musicwiki.repo.network.toptracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null
)