package com.barber.view;

import com.barber.model.Service;
import com.barber.model.User;

import java.util.List;
import java.util.Objects;

public class MasterDTO {
    private int id;
private User master;
    private String photoImgPath;
    private List<Service> servicesList;
    private List<AppointmentTimeViewDto> appointmentSessionTime;

    public MasterDTO(int id, User master, String photoImgPath, List<Service> servicesList, List<AppointmentTimeViewDto> appointmentSessionTime) {
        this.id = id;
        this.master = master;
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

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
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
                master.equals(masterDTO.master) &&
                photoImgPath.equals(masterDTO.photoImgPath) &&
                servicesList.equals(masterDTO.servicesList) &&
                appointmentSessionTime.equals(masterDTO.appointmentSessionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, master, photoImgPath, servicesList, appointmentSessionTime);
    }

    @Override
    public String toString() {
        return "MasterDTO{" +
                "id=" + id +
                ", user=" + master +
                ", photoImgPath='" + photoImgPath + '\'' +
                ", servicesList=" + servicesList +
                ", appointmentSessionTime=" + appointmentSessionTime +
                '}';
    }
}
