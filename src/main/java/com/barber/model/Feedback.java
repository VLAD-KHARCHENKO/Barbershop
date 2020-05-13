package com.barber.model;

import java.time.LocalDateTime;

public class Feedback {
    private int id;
    private LocalDateTime date;
    private String feedback;
    private int userId;

    public Feedback(int id, LocalDateTime date, String feedback, int userId) {
        this.id = id;
        this.date = date;
        this.feedback = feedback;
        this.userId = userId;

    }

    public Feedback(LocalDateTime date, String message, int userId) {
        this.date = date;
        this.feedback = message;
        this.userId = userId;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", date='" + date + ", feedback='" + feedback +
                '\'' + ", userId='" + userId + '\'' +
                '}' + "\n";
    }
}
