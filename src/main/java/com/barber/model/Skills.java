package com.barber.model;

import java.util.Objects;

public class Skills {
    private int id;
    private int userId;
    private int serviceId;

    public Skills(int id, int userId, int serviceId) {
        this.id = id;
        this.userId = userId;
        this.serviceId = serviceId;
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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return id == skills.id &&
                userId == skills.userId &&
                serviceId == skills.serviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, serviceId);
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                '}';
    }
}