
package com.example.musicwiki.repo.network.artiststopalbums;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistTopAlbums {

    @SerializedName("topalbums")
    @Expose
    private Topalbums topalbums;

    public Topalbums getTopalbums() {
        return topalbums;
    }

    public void setTopalbums(Topalbums topalbums) {
        this.topalbums = topalbums;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ArtistTopAlbums.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("topalbums");
        sb.append('=');
        sb.append(((this.topalbums == null)?"<null>":this.topalbums));
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
        result = ((result* 31)+((this.topalbums == null)? 0 :this.topalbums.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ArtistTopAlbums) == false) {
            return false;
        }
        ArtistTopAlbums rhs = ((ArtistTopAlbums) other);
        return ((this.topalbums == rhs.topalbums)||((this.topalbums!= null)&&this.topalbums.equals(rhs.topalbums)));
    }

}
