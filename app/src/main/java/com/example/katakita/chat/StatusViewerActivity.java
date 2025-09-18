package com.example.katakita.chat;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.katakita.R;
import com.example.katakita.Repository.StatusRepository;
import com.example.katakita.model.StatusContentModel;
import com.example.katakita.model.UserStatusModel;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StatusViewerActivity extends AppCompatActivity {
    private boolean isActivityRunning = true;

    private ImageView imageView;
//    private ProgressBar progressBar;
    private TextView tvName, tvTime;

    private int userIndex = 0;
    private int storyIndex = 0;
    private ImageView imgView;
    private List<UserStatusModel> userStatusList;
    private Handler handler = new Handler();
    private LinearLayout progressContainer;
    private List<ProgressBar> progressBars = new ArrayList<>();

    private final int STORY_DURATION = 3000; // 3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_viewer);

        imageView = findViewById(R.id.imageStatus);
       // progressBar = findViewById(R.id.progressBar);
        tvName = findViewById(R.id.tvStatusName);
        tvTime = findViewById(R.id.tvStatusTime);
        progressContainer = findViewById(R.id.progressContainer);
        imgView = findViewById(R.id.imageProfile);


        userStatusList = StatusRepository.getAllStatuses();
        showStory();
    }

    private void showStory() {
        if (!isActivityRunning || isFinishing() || isDestroyed()) return;

        if (userIndex >= userStatusList.size()) {
            finish();
            return;
        }

        UserStatusModel currentUser = userStatusList.get(userIndex);
        List<StatusContentModel> stories = currentUser.getStatusList();

        // Kalau story baru dimulai (index == 0), inisialisasi progress bars
        if (storyIndex == 0) {
            runOnUiThread(() -> {
                progressContainer.removeAllViews();
                progressBars.clear();

                for (int i = 0; i < stories.size(); i++) {
                    ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                    bar.setLayoutParams(new LinearLayout.LayoutParams(0, 4, 1f));
                    bar.setMax(100);
                    bar.setProgress(0);
                    bar.setProgressDrawable(getDrawable(R.drawable.progress_bar)); // pakai custom style
                    bar.setIndeterminate(false);

                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) bar.getLayoutParams();
                    params.setMarginEnd(8); // spacing antar bar
                    bar.setLayoutParams(params);

                    progressContainer.addView(bar);
                    progressBars.add(bar);
                }
            });
        }

        Glide.with(StatusViewerActivity.this)
                .load(currentUser.getProfileImageUrl()) // Sesuai getter kamu
                .placeholder(R.drawable.ic_placeholder)
                .circleCrop()
                .into(imgView);


        if (storyIndex >= stories.size()) {
            storyIndex = 0;
            userIndex++;
            showStory(); // Lanjut ke user berikutnya
            return;
        }

        StatusContentModel currentStory = stories.get(storyIndex);

        runOnUiThread(() -> {
            Glide.with(StatusViewerActivity.this)
                    .load(currentStory.getImageUrl())
                    .into(imageView);

            tvName.setText(currentUser.getUserName());
            tvTime.setText(formatTime(currentStory.getTimestamp()));
        });

        new Thread(() -> {
            int progress = 0;
            while (progress <= 100 && isActivityRunning) {
                int finalProgress = progress;
                handler.post(() -> {
                    if (isActivityRunning && storyIndex < progressBars.size()) {
                        progressBars.get(storyIndex).setProgress(finalProgress);
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

