package com.example.musicwiki.repo.network.genreinfo

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Wiki (
    @SerializedName("summary")
    @Expose
    var summary: String? = null,

    @SerializedName("content")
    @Expose
    var content: String? = null
)