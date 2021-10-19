package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class TopAlbums (
    @SerializedName("albums")
    @Expose
    var albums: NetworkAlbums? = null
)