package com.example.katakita.model;


public class CallModel {
    private long timestamp;
    private String name;
    private String time;
    private boolean isVideo;
    private String imageUrl;
    private boolean isMissed; // ✅ Tambahan: status terjawab / tidak terjawab

    public CallModel(String name, String time, boolean isVideo, String imageUrl, boolean isMissed, long timestamp) {
        this.name = name;
        this.time = time;
        this.isVideo = isVideo;
        this.imageUrl = imageUrl;
        this.isMissed = isMissed;
        this.timestamp = timestamp;
    }

    public String getName() { return name; }
    public String getTime() { return time; }
    public boolean isVideo() { return isVideo; }
    public String getImageUrl() { return imageUrl; }
    public boolean isMissed() { return isMissed; }
    public long getTimestamp() { return timestamp; }
}
