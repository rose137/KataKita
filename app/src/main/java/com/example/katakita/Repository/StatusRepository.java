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
                "https://example.com/profile/rina.jpg",
                Arrays.asList(
                        new StatusContentModel("https://example.com/status/rina_1.jpg", System.currentTimeMillis() - 100000),
                        new StatusContentModel("https://example.com/status/rina_2.jpg", System.currentTimeMillis() - 50000)
                )
        ));

        list.add(new UserStatusModel(
                "Budi",
                "https://example.com/profile/budi.jpg",
                Arrays.asList(
                        new StatusContentModel("https://example.com/status/budi_1.jpg", System.currentTimeMillis() - 200000)
                )
        ));

        list.add(new UserStatusModel(
                "Sari",
                "https://example.com/profile/sari.jpg",
                Arrays.asList(
                        new StatusContentModel("https://example.com/status/sari_1.jpg", System.currentTimeMillis() - 300000),
                        new StatusContentModel("https://example.com/status/sari_2.jpg", System.currentTimeMillis() - 200000),
                        new StatusContentModel("https://example.com/status/sari_3.jpg", System.currentTimeMillis() - 100000)
                )
        ));

        return list;
    }
}
