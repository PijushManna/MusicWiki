package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Artist (
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