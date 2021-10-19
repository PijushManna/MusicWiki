
package com.example.musicwiki.repo.network.topartists;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topartists {

    @SerializedName("artist")
    @Expose
    public List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    public Attr__1 attr;

}
