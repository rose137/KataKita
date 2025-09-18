package com.example.katakita.Repository;


import com.example.katakita.model.CallModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CallRepository {

    public static List<CallModel> getDummyCalls() {
        List<CallModel> callList = new ArrayList<>();
        String[] names = { "Rina", "Budi", "Sari", "Joko", "Nina", "Dewi", "Rudi", "Ayu", "Fajar", "Lina",
                "Tono", "Citra", "Bayu", "Dian", "Raka", "Tari", "Imam", "Vina", "Bagas", "Wulan" };

        String[] imageUrls = {
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/anya1.jpg",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/anya2.jpg",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/anya3.jpg",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe1.jpg",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe2.jpg",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe3.jpg",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/nezu1.jpg"
        };

        Random random = new Random();
        long now = System.currentTimeMillis();

        for (int i = 0; i < 20; i++) {
            String name = names[i % names.length];
            boolean isVideo = random.nextBoolean();
            boolean isMissed = random.nextBoolean();
            String imageUrl = imageUrls[random.nextInt(imageUrls.length)];

            long timestamp = now - random.nextInt(1000 * 60 * 60 * 24 * 7); // 0-7 hari lalu
            String time = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()).format(new Date(timestamp));

            callList.add(new CallModel(name, time, isVideo, imageUrl, isMissed, timestamp));
        }

        // Sort descending by timestamp
        Collections.sort(callList, (o1, o2) -> Long.compare(o2.getTimestamp(), o1.getTimestamp()));

        return callList;
    }

}
