package com.example.katakita.chat;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.katakita.R;
import com.example.katakita.Repository.StatusRepository;
import com.example.katakita.model.StatusContentModel;
import com.example.katakita.model.UserStatusModel;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class StatusViewerActivity extends AppCompatActivity {
    private boolean isActivityRunning = true;

    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView tvName, tvTime;

    private int userIndex = 0;
    private int storyIndex = 0;

    private List<UserStatusModel> userStatusList;
    private Handler handler = new Handler();
    private final int STORY_DURATION = 3000; // 3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_viewer);

        imageView = findViewById(R.id.imageStatus);
        progressBar = findViewById(R.id.progressBar);
        tvName = findViewById(R.id.tvStatusName);
        tvTime = findViewById(R.id.tvStatusTime);

        userStatusList = StatusRepository.getAllStatuses();
        showStory();
    }

    private void showStory() {
        if (!isActivityRunning || isFinishing() || isDestroyed()) {
            return;
        }

        if (userIndex >= userStatusList.size()) {
            finish();
            return;
        }

        UserStatusModel currentUser = userStatusList.get(userIndex);
        List<StatusContentModel> stories = currentUser.getStatusList();

        if (storyIndex >= stories.size()) {
            storyIndex = 0;
            userIndex++;
            showStory();
            return;
        }

        StatusContentModel currentStory = stories.get(storyIndex);

        // Cek ulang sebelum load Glide
        if (!isFinishing() && !isDestroyed() && isActivityRunning) {
            runOnUiThread(() -> {
                Glide.with(StatusViewerActivity.this)
                        .load(currentStory.getImageUrl())
                        .into(imageView);

                tvName.setText(currentUser.getUserName());
                tvTime.setText(formatTime(currentStory.getTimestamp()));
            });
        }

        // Reset progress bar
        progressBar.setProgress(0);

        new Thread(() -> {
            int progress = 0;
            while (progress <= 100 && isActivityRunning) {
                int finalProgress = progress;
                handler.post(() -> {
                    if (isActivityRunning) {
                        progressBar.setProgress(finalProgress);
                    }
                });
                progress += 2;
                try {
                    Thread.sleep(STORY_DURATION / 50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            storyIndex++;
            handler.post(() -> {
                if (isActivityRunning) {
                    showStory();
                }
            });
        }).start();
    }

    private String formatTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return sdf.format(timestamp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isActivityRunning = false;
        handler.removeCallbacksAndMessages(null); // stop handler juga
    }

}

