
package com.example.musicwiki.repo.network.artistinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tags {

    @SerializedName("tag")
    @Expose
    private List<Tag> tag = null;

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Tags.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tag");
        sb.append('=');
        sb.append(((this.tag == null)?"<null>":this.tag));
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
        result = ((result* 31)+((this.tag == null)? 0 :this.tag.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tags) == false) {
            return false;
        }
        Tags rhs = ((Tags) other);
        return ((this.tag == rhs.tag)||((this.tag!= null)&&this.tag.equals(rhs.tag)));
    }

}
