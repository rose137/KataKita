package com.example.katakita.model;

public class ChatMessageModel {
    private String message;
    private String time;
    private MessageStatus status; // ENUM status
    private boolean isSentByUser; // true = pesan dikirim user, false = diterima


    public ChatMessageModel(String message, String time, MessageStatus  status,boolean isSentByUser) {
        this.message = message;
        this.time = time;
        this.status = status;
        this.isSentByUser = isSentByUser;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }

    public String getTime() {
        return time;
    }
    public MessageStatus getStatus() {
        return status;
    }
}
