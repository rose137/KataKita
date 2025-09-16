package com.example.katakita.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.katakita.R;
import com.example.katakita.chat.chatActivity;

public class viewActivity extends AppCompatActivity {
Button btnMulai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ImageView imageView = findViewById(R.id.characterImage);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.floating_anim);
        imageView.startAnimation(animation);

        btnMulai = findViewById(R.id.getStartedBtn);

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent ke Activity lain
                Intent intent = new Intent(viewActivity.this, chatActivity.class);
                startActivity(intent);
            }
        });
    }



}