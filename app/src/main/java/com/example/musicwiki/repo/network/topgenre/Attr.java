
package com.example.musicwiki.repo.network.topgenre;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr {

    @SerializedName("offset")
    @Expose
    public Integer offset;
    @SerializedName("num_res")
    @Expose
    public Integer numRes;
    @SerializedName("total")
    @Expose
    public Integer total;

}
