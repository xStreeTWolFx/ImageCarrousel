package com.example.carrousel.model.typeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ListConverter {
    @TypeConverter
    public static List<Integer> restoreList(String ratings) {
        return new Gson().fromJson(ratings, new TypeToken<List<Integer>>() {
        }.getType());
    }

    @TypeConverter
    public static String saveList(List<Integer> ratings) {
        return new Gson().toJson(ratings);
    }

}
