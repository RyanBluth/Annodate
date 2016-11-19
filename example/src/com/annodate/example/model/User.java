package com.annodate.example.model;


import com.annodate.annotations.*;

public class User {

    @MaxLength(20)
    @Letters
    private String firstName;

    @MaxLength(20)
    @Letters
    private String lastName;

    @Email
    private String email;

    @MinLength(8)
    private String password;

    @MatchPattern("A#A #A#")
    private String postalCode;

    @MatchPattern("(###) ###-####")
    @Numeric(ignoreChars = {' ', '(', ')', '-'})
    private String phoneNumber;



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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
