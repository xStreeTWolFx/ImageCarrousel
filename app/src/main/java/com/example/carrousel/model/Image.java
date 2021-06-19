package com.example.carrousel.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.carrousel.model.typeConverters.ListConverter;

import java.util.List;

@Entity(tableName = "images")
public class Image {

    @TypeConverters(ListConverter.class)
    public List<Integer> ratings;
    @PrimaryKey()
    @NonNull
    private String id;
    private String maker;
    private String image;
    private String url;
    private String title;
    private String description;


    public Image(@NonNull String id, String maker, String image, String url, String title, String description, List<Integer> ratings) {
        this.id = id;
        this.maker = maker;
        this.image = image;
        this.url = url;
        this.title = title;
        this.description = description;
        this.ratings = ratings;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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
