
package com.example.musicwiki.repo.network.artistinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Link.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("rel");
        sb.append('=');
        sb.append(((this.rel == null)?"<null>":this.rel));
        sb.append(',');
        sb.append("href");
        sb.append('=');
        sb.append(((this.href == null)?"<null>":this.href));
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
        result = ((result* 31)+((this.rel == null)? 0 :this.rel.hashCode()));
        result = ((result* 31)+((this.text == null)? 0 :this.text.hashCode()));
        result = ((result* 31)+((this.href == null)? 0 :this.href.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Link) == false) {
            return false;
        }
        Link rhs = ((Link) other);
        return ((((this.rel == rhs.rel)||((this.rel!= null)&&this.rel.equals(rhs.rel)))&&((this.text == rhs.text)||((this.text!= null)&&this.text.equals(rhs.text))))&&((this.href == rhs.href)||((this.href!= null)&&this.href.equals(rhs.href))));
    }

}
