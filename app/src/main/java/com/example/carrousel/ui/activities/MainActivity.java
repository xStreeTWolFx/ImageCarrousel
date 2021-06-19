package com.example.carrousel.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.carrousel.R;
import com.example.carrousel.network.mapper.CarouselMapper;
import com.example.carrousel.utilities.NetworkUtil;
import com.example.carrousel.viewmodel.ImageViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ImageCarousel carousel;
    private ImageView placeholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageViewModel viewModel = new ViewModelProvider(this).get(ImageViewModel.class);
        carousel = findViewById(R.id.carousel);
        carousel.registerLifecycle(this);
        placeholder = findViewById(R.id.placeholder);
        FloatingActionButton floatingActionButton = findViewById(R.id.buton_refresh);
        floatingActionButton.setOnClickListener(v -> {
            viewModel.getImages();
        });
        viewModel.getImages().observe(this,
                images -> {
                    //TODO: Remover delay cuando la libreria maneje el error de "ImageCarousel: The first view is not found!".
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException ignored) {
                    }
                    if (NetworkUtil.isConnected(this)) {
                        placeholder.setVisibility(View.GONE);
                        carousel.setVisibility(View.VISIBLE);
                        carousel.addData(CarouselMapper.toCarouselItem(images));
                    } else {
                        placeholder.setVisibility(View.VISIBLE);
                        carousel.setVisibility(View.GONE);
                    }
                });
    }
}