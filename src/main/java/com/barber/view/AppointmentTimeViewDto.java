package com.barber.view;



import com.barber.model.User;

import java.time.LocalTime;
import java.util.Objects;


public class AppointmentTimeViewDto {
    private int id;
    private User user;
    private LocalTime startAt;
    private boolean isBooked;

    public AppointmentTimeViewDto(int id, User user, LocalTime startAt, boolean isBooked) {
        this.id = id;
        this.user = user;
        this.startAt = startAt;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalTime startAt) {
        this.startAt = startAt;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentTimeViewDto that = (AppointmentTimeViewDto) o;
        return id == that.id &&
                isBooked == that.isBooked &&
                user.equals(that.user) &&
                startAt.equals(that.startAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, startAt, isBooked);
    }

    @Override
    public String toString() {
        return "AppointmentTimeViewDto{" +
                "id=" + id +
                ", user=" + user +
                ", startAt=" + startAt +
                ", isBooked=" + isBooked +
                '}';
    }
}