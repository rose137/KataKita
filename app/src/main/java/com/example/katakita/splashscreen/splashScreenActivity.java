package com.example.katakita.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.katakita.MainActivity;
import com.example.katakita.R;

public class splashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logo = findViewById(R.id.logoImage);

        // Load animasi
//        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        // Jalankan animasi
        logo.startAnimation(scaleUp);
        // Delay 3 detik sebelum pindah ke MainActivity
        new Handler().postDelayed(() -> {
            startActivity(new Intent(splashScreenActivity.this, viewActivity.class));
            finish(); // agar tidak kembali ke splash
        }, 3000);
    }
}