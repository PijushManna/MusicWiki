
package com.example.musicwiki.repo.network.artiststoptracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ArtistTopTracks {

    @SerializedName("toptracks")
    @Expose
    private Toptracks toptracks;

    public Toptracks getToptracks() {
        return toptracks;
    }

    public void setToptracks(Toptracks toptracks) {
        this.toptracks = toptracks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ArtistTopTracks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("toptracks");
        sb.append('=');
        sb.append(((this.toptracks == null)?"<null>":this.toptracks));
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
        result = ((result* 31)+((this.toptracks == null)? 0 :this.toptracks.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ArtistTopTracks) == false) {
            return false;
        }
        ArtistTopTracks rhs = ((ArtistTopTracks) other);
        return ((this.toptracks == rhs.toptracks)||((this.toptracks!= null)&&this.toptracks.equals(rhs.toptracks)));
    }

}
