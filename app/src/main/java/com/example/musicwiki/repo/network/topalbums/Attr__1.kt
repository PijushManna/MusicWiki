package com.example.musicwiki.repo.network.topalbums

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Attr__1 (
    @SerializedName("tag")
    @Expose
    var tag: String? = null,

    @SerializedName("page")
    @Expose
    var page: String? = null,

    @SerializedName("perPage")
    @Expose
    var perPage: String? = null,

    @SerializedName("totalPages")
    @Expose
    var totalPages: String? = null,

    @SerializedName("total")
    @Expose
    var total: String? = null
)