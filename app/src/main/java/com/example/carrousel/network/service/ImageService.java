package com.example.carrousel.network.service;

import androidx.annotation.NonNull;

import com.example.carrousel.network.ClientUsage;
import com.example.carrousel.network.apiService.ImageApi;
import com.example.carrousel.network.dto.ImageDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageService {

    public void getImages(OnGet callback) {
        ImageApi service = ClientUsage.getRetrofitInstance().create(ImageApi.class);
        Call<List<ImageDTO>> call = service.getImages();
        call.enqueue(new Callback<List<ImageDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<ImageDTO>> call, @NonNull Response<List<ImageDTO>> response) {
                callback.onResponse(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<List<ImageDTO>> call, @NonNull Throwable t) {
                callback.onFailure(null);
            }
        });
    }

    public interface OnGet {
        void onResponse(List<ImageDTO> response);

        void onFailure(Object error);
    }
}
