package com.example.demo.entity;

public class UserRegister{
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String carNumber;

    private static final String salt = com.appsdeveloperblog.encryption.PasswordUtils.getSalt(30);
    public String getUsername() {
        return username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void generatePassword(String password){

        this.password= com.appsdeveloperblog.encryption.PasswordUtils.generateSecurePassword(password,salt);
    }
}
