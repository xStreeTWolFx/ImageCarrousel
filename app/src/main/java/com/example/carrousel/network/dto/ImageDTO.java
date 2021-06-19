package com.example.carrousel.network.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageDTO {

    @SerializedName("Id")
    private String id;
    @SerializedName("Maker")
    private String maker;
    @SerializedName("img")
    private String image;
    @SerializedName("Url")
    private String url;
    @SerializedName("Title")
    private String title;
    @SerializedName("Description")
    private String description;
    @SerializedName("Ratings")
    private List<Integer> ratings;

    public ImageDTO() {
    }

    public ImageDTO(String id, String maker, String image, String url, String title, String description, List<Integer> ratings) {
        this.id = id;
        this.maker = maker;
        this.image = image;
        this.url = url;
        this.title = title;
        this.description = description;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }
}
