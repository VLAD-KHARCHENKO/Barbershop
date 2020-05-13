package com.barber.view;

import com.barber.model.Service;
import com.barber.model.User;
import com.barber.model.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MasterDTO {
    private int id;
private User user;
    private String photoImgPath;
    private List<Service> servicesList;
    private List<AppointmentTimeViewDto> appointmentSessionTime;

    public MasterDTO(int id, User user, String photoImgPath, List<Service> servicesList, List<AppointmentTimeViewDto> appointmentSessionTime) {
        this.id = id;
        this.user = user;
        this.photoImgPath = photoImgPath;
        this.servicesList = servicesList;
        this.appointmentSessionTime = appointmentSessionTime;
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

    public String getPhotoImgPath() {
        return photoImgPath;
    }

    public void setPhotoImgPath(String photoImgPath) {
        this.photoImgPath = photoImgPath;
    }

    public List<Service> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<Service> servicesList) {
        this.servicesList = servicesList;
    }

    public List<AppointmentTimeViewDto> getAppointmentSessionTime() {
        return appointmentSessionTime;
    }

    public void setAppointmentSessionTime(List<AppointmentTimeViewDto> appointmentSessionTime) {
        this.appointmentSessionTime = appointmentSessionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterDTO masterDTO = (MasterDTO) o;
        return id == masterDTO.id &&
                user.equals(masterDTO.user) &&
                photoImgPath.equals(masterDTO.photoImgPath) &&
                servicesList.equals(masterDTO.servicesList) &&
                appointmentSessionTime.equals(masterDTO.appointmentSessionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, photoImgPath, servicesList, appointmentSessionTime);
    }

    @Override
    public String toString() {
        return "MasterDTO{" +
                "id=" + id +
                ", user=" + user +
                ", photoImgPath='" + photoImgPath + '\'' +
                ", servicesList=" + servicesList +
                ", appointmentSessionTime=" + appointmentSessionTime +
                '}';
    }
}
