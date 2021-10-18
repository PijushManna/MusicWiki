package com.example.musicwiki.repo.network.genreinfo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TagInfo (
    @SerializedName("tag")
    @Expose
    var tag: InfoTag? = null
)