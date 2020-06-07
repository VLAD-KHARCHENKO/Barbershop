package com.barber.model;

import java.time.LocalDateTime;

public class Master {
    private int id;
    private int userId;
    private String photo;


    public Master(int id, int userId, String photo) {
        this.id = id;
        this.userId = userId;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", userId=" + userId +
                ", photo='" + photo + '\'' +
                '}';
    }
}

