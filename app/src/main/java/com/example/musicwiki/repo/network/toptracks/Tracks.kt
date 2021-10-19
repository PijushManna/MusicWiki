package com.example.musicwiki.repo.network.toptracks

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tracks (
    @SerializedName("track")
    @Expose
    var track: List<Track>? = null,

    @SerializedName("@attr")
    @Expose
    var attr: Attr__1? = null
)