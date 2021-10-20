
package com.example.musicwiki.repo.network.artiststoptracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("playcount")
    @Expose
    private String playcount;
    @SerializedName("listeners")
    @Expose
    private String listeners;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("artist")
    @Expose
    private Artist artist;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
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

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Track.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("playcount");
        sb.append('=');
        sb.append(((this.playcount == null)?"<null>":this.playcount));
        sb.append(',');
        sb.append("listeners");
        sb.append('=');
        sb.append(((this.listeners == null)?"<null>":this.listeners));
        sb.append(',');
        sb.append("mbid");
        sb.append('=');
        sb.append(((this.mbid == null)?"<null>":this.mbid));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("streamable");
        sb.append('=');
        sb.append(((this.streamable == null)?"<null>":this.streamable));
        sb.append(',');
        sb.append("artist");
        sb.append('=');
        sb.append(((this.artist == null)?"<null>":this.artist));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
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
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.mbid == null)? 0 :this.mbid.hashCode()));
        result = ((result* 31)+((this.listeners == null)? 0 :this.listeners.hashCode()));
        result = ((result* 31)+((this.streamable == null)? 0 :this.streamable.hashCode()));
        result = ((result* 31)+((this.artist == null)? 0 :this.artist.hashCode()));
        result = ((result* 31)+((this.playcount == null)? 0 :this.playcount.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.attr == null)? 0 :this.attr.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Track) == false) {
            return false;
        }
        Track rhs = ((Track) other);
        return ((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.mbid == rhs.mbid)||((this.mbid!= null)&&this.mbid.equals(rhs.mbid))))&&((this.listeners == rhs.listeners)||((this.listeners!= null)&&this.listeners.equals(rhs.listeners))))&&((this.streamable == rhs.streamable)||((this.streamable!= null)&&this.streamable.equals(rhs.streamable))))&&((this.artist == rhs.artist)||((this.artist!= null)&&this.artist.equals(rhs.artist))))&&((this.playcount == rhs.playcount)||((this.playcount!= null)&&this.playcount.equals(rhs.playcount))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.attr == rhs.attr)||((this.attr!= null)&&this.attr.equals(rhs.attr))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
