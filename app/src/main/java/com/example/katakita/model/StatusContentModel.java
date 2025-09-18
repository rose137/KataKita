package com.example.katakita.model;


public class StatusContentModel {
    private String imageUrl;
    private long timestamp;

    public StatusContentModel(String imageUrl, long timestamp) {
        this.imageUrl = imageUrl;
        this.timestamp = timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
