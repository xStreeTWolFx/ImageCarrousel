package com.example.carrousel.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.carrousel.database.Database;
import com.example.carrousel.database.dao.ImageDao;
import com.example.carrousel.model.Image;
import com.example.carrousel.network.dto.ImageDTO;
import com.example.carrousel.network.mapper.ImageMapper;
import com.example.carrousel.network.service.ImageService;
import com.example.carrousel.utilities.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

public class ImageRepository {
    private final ImageDao imageDao;
    private final ImageService service;
    private final MutableLiveData<List<Image>> imageLive;
    Database db;

    public ImageRepository(Context context) {
        db = Database.getDatabase(context);
        imageDao = db.imageDao();
        service = new ImageService();
        imageLive = new MutableLiveData<>();
    }

    public LiveData<List<Image>> getImages(Context context) {
        if (NetworkUtil.isConnected(context)) {
            callService();
            imageLive.setValue(new ArrayList<>());
        } else {
            getImages();
        }
        return imageLive;
    }

    private void callService() {
        service.getImages(new ImageService.OnGet() {
            @Override
            public void onResponse(List<ImageDTO> response) {
                List<Image> images = new ArrayList<>();

                if (response != null) {
                    for (ImageDTO imageDTO : response) {
                        images.add(ImageMapper.dtoToObject(imageDTO));
                    }
                    insert(new ArrayList<>(images));
                    imageLive.setValue(images);
                }
            }

            @Override
            public void onFailure(Object error) {
                imageLive.setValue(new ArrayList<>());

            }
        });
    }

    public void insert(Image image) {
        Database.databaseWriteExecutor.execute(() -> imageDao.insert(image));
    }

    public void insert(ArrayList<Image> images) {
        Database.databaseWriteExecutor.execute(() -> imageDao.insertAll(images));
    }

    public void deleteAll(Image... images) {
        Database.databaseWriteExecutor.execute(() -> imageDao.deleteAll(images));
    }

    public void deleteAll() {
        Database.databaseWriteExecutor.execute(imageDao::deleteAll);
    }

    public void getImages() {
        Database.databaseWriteExecutor.execute(() -> imageLive.postValue(imageDao.getAllImages()));
    }
}
