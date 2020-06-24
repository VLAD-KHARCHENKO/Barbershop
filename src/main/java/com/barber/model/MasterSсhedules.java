package com.barber.model;

import com.barber.model.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class MasterSсhedules {
    private int id;
    private int userId;
    private LocalDateTime startAt;
  private BookingStatus bookingStatus;
    private int masterId;

    public MasterSсhedules(int id, int userId, LocalDateTime startAt, BookingStatus bookingStatus, int masterId) {
        this.id = id;
        this.userId = userId;
        this.startAt = startAt;
        this.bookingStatus = bookingStatus;
        this.masterId = masterId;
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

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterSсhedules sсhedule = (MasterSсhedules) o;
        return id == sсhedule.id &&
                userId == sсhedule.userId &&
                masterId == sсhedule.masterId &&
                startAt.equals(sсhedule.startAt) &&
                bookingStatus == sсhedule.bookingStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, startAt, bookingStatus, masterId);
    }

    @Override
    public String toString() {
        return "Sсhedule{" +
                "id=" + id +
                ", userId=" + userId +
                ", startAt=" + startAt +
                ", bookingStatus=" + bookingStatus +
                ", masterId=" + masterId +
                '}';
    }
}