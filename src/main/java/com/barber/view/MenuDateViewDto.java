package com.barber.view;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class MenuDateViewDto {


    private LocalDate date;


    private boolean isActive;

    public MenuDateViewDto(LocalDate date) {
        if(date== null){
            throw new NullPointerException("date is NULL");
        }
        this.date = date;

    }


    public LocalDate getDate() {
        return date;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setActive(boolean active) {
        isActive = active;
    }



    public String getIsoDate(){
        return "?date=" + date.format(DateTimeFormatter.ISO_DATE);
    }

    public String getDayOfWeek(){
        return date.getDayOfWeek().name().substring(0,3).toLowerCase();
    }

    public String getFormattedDate(){
        return " "+ date.format(DateTimeFormatter.ofPattern("dd.MM"));
    }


    @Override
    public String toString() {
        return "MenuDateViewDto{" +
                "date=" + date +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDateViewDto that = (MenuDateViewDto) o;
        return isActive == that.isActive &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, isActive);
    }
}
