
package com.example.musicwiki.repo.network.artistinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Artist {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;
    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("ontour")
    @Expose
    private String ontour;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("similar")
    @Expose
    private Similar similar;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("bio")
    @Expose
    private Bio bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public String getOntour() {
        return ontour;
    }

    public void setOntour(String ontour) {
        this.ontour = ontour;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Similar getSimilar() {
        return similar;
    }

    public void setSimilar(Similar similar) {
        this.similar = similar;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public Bio getBio() {
        return bio;
    }

    public void setBio(Bio bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Artist.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("mbid");
        sb.append('=');
        sb.append(((this.mbid == null)?"<null>":this.mbid));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("streamable");
        sb.append('=');
        sb.append(((this.streamable == null)?"<null>":this.streamable));
        sb.append(',');
        sb.append("ontour");
        sb.append('=');
        sb.append(((this.ontour == null)?"<null>":this.ontour));
        sb.append(',');
        sb.append("stats");
        sb.append('=');
        sb.append(((this.stats == null)?"<null>":this.stats));
        sb.append(',');
        sb.append("similar");
        sb.append('=');
        sb.append(((this.similar == null)?"<null>":this.similar));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("bio");
        sb.append('=');
        sb.append(((this.bio == null)?"<null>":this.bio));
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
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.similar == null)? 0 :this.similar.hashCode()));
        result = ((result* 31)+((this.mbid == null)? 0 :this.mbid.hashCode()));
        result = ((result* 31)+((this.streamable == null)? 0 :this.streamable.hashCode()));
        result = ((result* 31)+((this.stats == null)? 0 :this.stats.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.ontour == null)? 0 :this.ontour.hashCode()));
        result = ((result* 31)+((this.bio == null)? 0 :this.bio.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Artist) == false) {
            return false;
        }
        Artist rhs = ((Artist) other);
        return (((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.similar == rhs.similar)||((this.similar!= null)&&this.similar.equals(rhs.similar))))&&((this.mbid == rhs.mbid)||((this.mbid!= null)&&this.mbid.equals(rhs.mbid))))&&((this.streamable == rhs.streamable)||((this.streamable!= null)&&this.streamable.equals(rhs.streamable))))&&((this.stats == rhs.stats)||((this.stats!= null)&&this.stats.equals(rhs.stats))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.ontour == rhs.ontour)||((this.ontour!= null)&&this.ontour.equals(rhs.ontour))))&&((this.bio == rhs.bio)||((this.bio!= null)&&this.bio.equals(rhs.bio))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }

}
