package com.example.musicwiki.repo.network.genreinfo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InfoTag (
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("total")
    @Expose
    var total: Int? = null,

    @SerializedName("reach")
    @Expose
    var reach: Int? = null,

    @SerializedName("wiki")
    @Expose
    var wiki: Wiki? = null
)