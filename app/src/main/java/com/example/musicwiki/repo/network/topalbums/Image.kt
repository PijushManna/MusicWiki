package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Image (
    @SerializedName("#text")
    @Expose
    var text: String? = null,

    @SerializedName("size")
    @Expose
    var size: String? = null
)