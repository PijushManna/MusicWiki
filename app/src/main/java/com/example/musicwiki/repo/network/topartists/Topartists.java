
package com.example.musicwiki.repo.network.topartists;

import java.util.List;
import javax.annotation.Generated;

import com.example.musicwiki.Artist;
import com.example.musicwiki.Attr__1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Topartists {

    @SerializedName("artist")
    @Expose
    public List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    public Attr__1 attr;

}
