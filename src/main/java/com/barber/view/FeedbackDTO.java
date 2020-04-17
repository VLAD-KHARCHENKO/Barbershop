package com.barber.view;

import java.time.LocalDateTime;

public class FeedbackDTO {
    private int id;
    private LocalDateTime date;
    private String feedback;
    private UserDTO customer;
    private RepairDTO repair;

    public FeedbackDTO() {
    }

    public RepairDTO getRepair() {
        return repair;
    }

    public void setRepair(RepairDTO repair) {
        this.repair = repair;
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

    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }
}
