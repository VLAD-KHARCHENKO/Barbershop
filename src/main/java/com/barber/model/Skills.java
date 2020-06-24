package com.barber.model;

import java.util.Objects;

public class Skills {
    private int id;
    private int masterId;
    private int serviceId;

    public Skills(int id, int masterId, int serviceId) {
        this.id = id;
        this.masterId = masterId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
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
                masterId == skills.masterId &&
                serviceId == skills.serviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, masterId, serviceId);
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", masterId=" + masterId +
                ", serviceId=" + serviceId +
                '}';
    }
}