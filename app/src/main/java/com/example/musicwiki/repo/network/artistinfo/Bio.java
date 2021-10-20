
package com.example.musicwiki.repo.network.artistinfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bio {

    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("content")
    @Expose
    private String content;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Bio.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("published");
        sb.append('=');
        sb.append(((this.published == null)?"<null>":this.published));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
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
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        result = ((result* 31)+((this.published == null)? 0 :this.published.hashCode()));
        result = ((result* 31)+((this.content == null)? 0 :this.content.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Bio) == false) {
            return false;
        }
        Bio rhs = ((Bio) other);
        return (((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links))))&&((this.published == rhs.published)||((this.published!= null)&&this.published.equals(rhs.published))))&&((this.content == rhs.content)||((this.content!= null)&&this.content.equals(rhs.content))));
    }

}
