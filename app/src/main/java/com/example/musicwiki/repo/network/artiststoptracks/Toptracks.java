
package com.example.musicwiki.repo.network.artiststoptracks;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Toptracks {

    @SerializedName("track")
    @Expose
    private List<Track> track = null;
    @SerializedName("@attr")
    @Expose
    private Attr__1 attr;

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

    public Attr__1 getAttr() {
        return attr;
    }

    public void setAttr(Attr__1 attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Toptracks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("track");
        sb.append('=');
        sb.append(((this.track == null)?"<null>":this.track));
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
        result = ((result* 31)+((this.track == null)? 0 :this.track.hashCode()));
        result = ((result* 31)+((this.attr == null)? 0 :this.attr.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Toptracks) == false) {
            return false;
        }
        Toptracks rhs = ((Toptracks) other);
        return (((this.track == rhs.track)||((this.track!= null)&&this.track.equals(rhs.track)))&&((this.attr == rhs.attr)||((this.attr!= null)&&this.attr.equals(rhs.attr))));
    }

}
