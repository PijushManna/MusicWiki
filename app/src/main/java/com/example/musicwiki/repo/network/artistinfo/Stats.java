
package com.example.musicwiki.repo.network.artistinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("listeners")
    @Expose
    private String listeners;
    @SerializedName("playcount")
    @Expose
    private String playcount;

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stats.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("listeners");
        sb.append('=');
        sb.append(((this.listeners == null)?"<null>":this.listeners));
        sb.append(',');
        sb.append("playcount");
        sb.append('=');
        sb.append(((this.playcount == null)?"<null>":this.playcount));
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
        result = ((result* 31)+((this.listeners == null)? 0 :this.listeners.hashCode()));
        result = ((result* 31)+((this.playcount == null)? 0 :this.playcount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stats) == false) {
            return false;
        }
        Stats rhs = ((Stats) other);
        return (((this.listeners == rhs.listeners)||((this.listeners!= null)&&this.listeners.equals(rhs.listeners)))&&((this.playcount == rhs.playcount)||((this.playcount!= null)&&this.playcount.equals(rhs.playcount))));
    }

}
