package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.lang.StringBuilder

data class Image (
    @SerializedName("#text")
    @Expose
    val text: String? = null,

    @SerializedName("size")
    @Expose
    val size: String? = null
)