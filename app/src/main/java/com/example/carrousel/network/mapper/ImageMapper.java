package com.example.carrousel.network.mapper;

import com.example.carrousel.model.Image;
import com.example.carrousel.network.dto.ImageDTO;

public class ImageMapper {

    public static Image dtoToObject(ImageDTO dto) {
        return new Image(dto.getId(),
                dto.getMaker(),
                dto.getImage(),
                dto.getUrl(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getRatings());
    }
}
