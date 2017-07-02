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
    private String password;
    private String confirmation_password;


    public User(int id, String user_lastname, String user_firstname, String email, String employee_number, String password, String confirmation_password) {
        this.id = id;
        this.user_lastname = user_lastname;
        this.user_firstname = user_firstname;
        this.email = email;
        this.employee_number = employee_number;
        this.password = password;
        this.confirmation_password = confirmation_password;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmation_password() {
        return confirmation_password;
    }

    public void setConfirmation_password(String confirmation_password) {
        this.confirmation_password = confirmation_password;
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
