package com.example.carrousel.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.carrousel.model.Image;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Image image);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrayList<Image> images);

    @Query("DELETE FROM images")
    void deleteAll();

    @Delete
    void deleteAll(Image... images);

    @Query("SELECT * from images ORDER BY id DESC")
    List<Image> getAllImages();

}