package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView2 = findViewById(R.id.imageView2);
        Glide.with(this).load("https://www.runoob.com/wp-content/uploads/2015/05/1432977393_android.png").into(imageView2);
    }
}
