package com.example.carrousel.network.apiService;

import com.example.carrousel.network.dto.ImageDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImageApi {
    String ALL_ELEMENTS = "dotnet-presentations/ContosoCrafts/master/src/wwwroot/data/products.json";

    @GET(ALL_ELEMENTS)
    Call<List<ImageDTO>> getImages();
}
