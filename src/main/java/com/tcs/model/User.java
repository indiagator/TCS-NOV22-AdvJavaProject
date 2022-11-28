package com.tcs.model;

public class User
{ // Data Model Definition
    Credential credential;
    String fullname;
    String email;
    String phone;
    String city;
    String country;
    UserType type;

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Credential getCredential() {
        return credential;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public UserType getType() {
        return type;
    }
}
