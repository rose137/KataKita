package com.example.katakita.Repository;


import com.example.katakita.model.StatusContentModel;
import com.example.katakita.model.UserStatusModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatusRepository {

    public static List<UserStatusModel> getAllStatuses() {
        List<UserStatusModel> list = new ArrayList<>();

        list.add(new UserStatusModel(
                "Rina",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/anya1.jpg",
                Arrays.asList(
                        new StatusContentModel("https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/anya1.jpg", System.currentTimeMillis() - 100000),
                        new StatusContentModel("https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/anya2.jpg", System.currentTimeMillis() - 50000)
                )
        ));

        list.add(new UserStatusModel(
                "Budi",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/nezu1.jpg",
                Arrays.asList(
                        new StatusContentModel("https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/nezu1.jpg", System.currentTimeMillis() - 200000)
                )
        ));

        list.add(new UserStatusModel(
                "Sari",
                "https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe1.jpg",
                Arrays.asList(
                        new StatusContentModel("https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe1.jpg", System.currentTimeMillis() - 300000),
                        new StatusContentModel("https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe2.jpg", System.currentTimeMillis() - 200000),
                        new StatusContentModel("https://raw.githubusercontent.com/rose137/KataKita/refs/heads/main/assets/kafe3.jpg", System.currentTimeMillis() - 100000)
                )
        ));

        return list;
    }
}
