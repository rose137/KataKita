package com.example.katakita.model;


import java.util.List;

public class UserStatusModel {
    private String userName;
    private String profileImageUrl;
    private List<StatusContentModel> statusList;

    public UserStatusModel(String userName, String profileImageUrl, List<StatusContentModel> statusList) {
        this.userName = userName;
        this.profileImageUrl = profileImageUrl;
        this.statusList = statusList;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public List<StatusContentModel> getStatusList() {
        return statusList;
    }
}
