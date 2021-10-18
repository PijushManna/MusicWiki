package com.example.musicwiki.repo.network.genre

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Tag(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("count")
    @Expose
    var count: Int? = null,

    @SerializedName("reach")
    @Expose
    var reach: Int? = null
)