package com.example.musicwiki.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artists(
    @SerializedName("artist") @Expose
    val artist: List<Artist?>? = null,
    @SerializedName("@attr")
    @Expose
    val attr: Attr? = null,
)