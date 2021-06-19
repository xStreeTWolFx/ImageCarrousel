package com.example.carrousel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.carrousel.model.Image;
import com.example.carrousel.repository.ImageRepository;

import java.util.List;

public class ImageViewModel extends AndroidViewModel {
    private final ImageRepository repository;

    public ImageViewModel(@NonNull Application application) {
        super(application);
        repository = new ImageRepository(application);
    }

    public LiveData<List<Image>> getImages() {
        return repository.getImages(getApplication());
    }

}
