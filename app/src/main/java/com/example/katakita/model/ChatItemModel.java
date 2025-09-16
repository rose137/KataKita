package com.example.katakita.model;

public class ChatItemModel {
    private String name;
    private String lastMessage;
    private String time;
    private String profileImageResId;
    private boolean isOnline;
    private int unreadCount;



    public ChatItemModel(String name, String lastMessage, String time, String profileImageResId,boolean isOnline, int unreadCount) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.time = time;
        this.profileImageResId = profileImageResId;
        this.isOnline = isOnline;
        this.unreadCount = unreadCount;
    }

    public String getName() { return name; }
    public String getLastMessage() { return lastMessage; }
    public String getTime() { return time; }
    public String getProfileImageResId() {
        return profileImageResId;
    }

    public boolean isOnline() { return isOnline; }
    public int getUnreadCount() { return unreadCount; }
}
