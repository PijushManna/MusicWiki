
package com.example.musicwiki.repo.network.artiststopalbums;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Topalbums {

    @SerializedName("album")
    @Expose
    private List<Album> album = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Topalbums.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("album");
        sb.append('=');
        sb.append(((this.album == null)?"<null>":this.album));
        sb.append(',');
        sb.append("attr");
        sb.append('=');
        sb.append(((this.attr == null)?"<null>":this.attr));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.attr == null)? 0 :this.attr.hashCode()));
        result = ((result* 31)+((this.album == null)? 0 :this.album.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Topalbums) == false) {
            return false;
        }
        Topalbums rhs = ((Topalbums) other);
        return (((this.attr == rhs.attr)||((this.attr!= null)&&this.attr.equals(rhs.attr)))&&((this.album == rhs.album)||((this.album!= null)&&this.album.equals(rhs.album))));
    }

}
