
package com.example.musicwiki.repo.network.albumsinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("#text")
    @Expose
    private String text;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
