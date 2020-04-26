package com.barber.model;

import com.barber.model.enums.Role;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String login;
    private String password;
    private Role role;

    public User(int id, String firstName, String lastName, String phone, String login, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(String firstName, String lastName, String phone, String login, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.role = role;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
