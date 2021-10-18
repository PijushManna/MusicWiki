package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Attr (
    @SerializedName("page")
    @Expose
    val page: String? = null,

    @SerializedName("perPage")
    @Expose
    val perPage: String? = null,

    @SerializedName("totalPages")
    @Expose
    val totalPages: String? = null,

    @SerializedName("total")
    @Expose
    val total: String? = null
)