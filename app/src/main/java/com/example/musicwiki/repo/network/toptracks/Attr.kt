package com.example.musicwiki.repo.network.toptracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Attr (
    @SerializedName("rank")
    @Expose
    var rank: String? = null
)