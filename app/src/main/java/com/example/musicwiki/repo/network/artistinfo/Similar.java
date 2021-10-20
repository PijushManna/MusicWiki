
package com.example.musicwiki.repo.network.artistinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Similar {

    @SerializedName("artist")
    @Expose
    private List<Artist__1> artist = null;

    public List<Artist__1> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist__1> artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Similar.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("artist");
        sb.append('=');
        sb.append(((this.artist == null)?"<null>":this.artist));
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
        result = ((result* 31)+((this.artist == null)? 0 :this.artist.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Similar) == false) {
            return false;
        }
        Similar rhs = ((Similar) other);
        return ((this.artist == rhs.artist)||((this.artist!= null)&&this.artist.equals(rhs.artist)));
    }

}
