package com.flo.socoapplication;

/**
 * Created by florian on 01/07/17.
 */

public class User {

    private int id;
    private String user_lastname;
    private String user_firstname;
    private String email;
    private String employee_number;

    public User(int id, String user_lastname, String user_firstname, String email, String employee_number) {
        this.id = id;
        this.user_lastname = user_lastname;
        this.user_firstname = user_firstname;
        this.email = email;
        this.employee_number = employee_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(String employee_number) {
        this.employee_number = employee_number;
    }
}
