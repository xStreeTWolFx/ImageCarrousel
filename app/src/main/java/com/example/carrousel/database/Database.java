package com.example.carrousel.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.carrousel.database.dao.ImageDao;
import com.example.carrousel.model.Image;
import com.example.carrousel.model.typeConverters.ListConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Image.class}, version = 1, exportSchema = false)
@TypeConverters(ListConverter.class)
public abstract class Database extends RoomDatabase {
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static Database INSTANCE;


    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (androidx.room.Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class,
                            "image_database").build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ImageDao imageDao();

}
