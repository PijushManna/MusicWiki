package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Attr (
    @SerializedName("rank")
    @Expose
    val rank: String? = null
)