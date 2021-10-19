package com.example.musicwiki.repo.network.toptracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Streamable (
    @SerializedName("#text")
    @Expose
    var text: String? = null,

    @SerializedName("fulltrack")
    @Expose
    var fulltrack: String? = null
)