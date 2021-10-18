
package com.example.musicwiki.repo.network.topgenre;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Toptags {
    @SerializedName("@attr")
    @Expose
    public Attr attr;
    @SerializedName("tag")
    @Expose
    public List<Tag> tag = null;

}
