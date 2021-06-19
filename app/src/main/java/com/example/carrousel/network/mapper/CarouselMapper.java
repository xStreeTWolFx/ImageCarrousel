package com.example.carrousel.network.mapper;

import com.example.carrousel.model.Image;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class CarouselMapper {
    public static CarouselItem toCarouselItem(Image image) {
        return new CarouselItem(image.getImage(), image.getId());
    }

    public static List<CarouselItem> toCarouselItem(List<Image> image) {
        List<CarouselItem> result = new ArrayList<>();
        for (Image element : image) {
            result.add(toCarouselItem(element));
        }
        return result;
    }
}