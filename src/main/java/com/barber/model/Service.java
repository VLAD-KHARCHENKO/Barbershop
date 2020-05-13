package com.barber.model;

import com.barber.model.enums.Role;

import java.util.Objects;

public class Service {
    private int id;
    private String serviceName;
    private Double price;


    public Service(int id, String serviceName, Double price) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id &&
                serviceName.equals(service.serviceName) &&
                price.equals(service.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, price);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}