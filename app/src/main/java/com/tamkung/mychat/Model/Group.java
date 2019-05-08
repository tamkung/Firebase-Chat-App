package com.tamkung.mychat.Model;

public class Group {

    private String date;
    private String message;
    private String time;
    private String username;

    public Group(String date, String message, String time, String username) {
        this.date = date;
        this.message = message;
        this.time = time;
        this.username = username;
    }

    public Group() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
