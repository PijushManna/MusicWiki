
package com.example.musicwiki.repo.network.albumsinfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Streamable {

    @SerializedName("fulltrack")
    @Expose
    private String fulltrack;
    @SerializedName("#text")
    @Expose
    private String text;

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
