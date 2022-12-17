package com.sih.dorec;

public class DlUtil {

    String driving_liscence;
    String fistName;
    String lastName;
    String dob;
    String fatherName;
    String city;

    public DlUtil() {
    }

    public DlUtil(String driving_liscence, String fistName, String lastName, String dob, String fatherName, String city) {
        this.driving_liscence = driving_liscence;
        this.fistName = fistName;
        this.lastName = lastName;
        this.dob = dob;
        this.fatherName = fatherName;
        this.city = city;
    }



    public String getDriving_liscence() {
        return driving_liscence;
    }

    public void setDriving_liscence(String driving_liscence) {
        this.driving_liscence = driving_liscence;
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
