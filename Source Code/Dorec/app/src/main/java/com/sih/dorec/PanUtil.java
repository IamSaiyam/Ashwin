package com.sih.dorec;

public class PanUtil {

    String pan;
    String fistName;
    String lastName;
    String dob;
    String fatherName;
    String city;

    public PanUtil() {
    }

    public PanUtil(String pan, String fistName, String lastName, String dob, String fatherName, String city) {
        this.pan = pan;
        this.fistName = fistName;
        this.lastName = lastName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.city = city;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
