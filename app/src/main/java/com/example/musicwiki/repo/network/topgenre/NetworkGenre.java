
package com.example.musicwiki.repo.network.topgenre;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NetworkGenre {
    @SerializedName("toptags")
    @Expose
    public Toptags toptags;
}
