package com.example.musicwiki.repo.network.toptracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NetworkTracks (
    @SerializedName("tracks")
    @Expose
    var tracks: Tracks? = null
)