
package com.example.musicwiki.repo.network.artistinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("link")
    @Expose
    private Link link;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Links.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
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
        result = ((result* 31)+((this.link == null)? 0 :this.link.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return ((this.link == rhs.link)||((this.link!= null)&&this.link.equals(rhs.link)));
    }

}
