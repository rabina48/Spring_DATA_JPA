package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Person {
    private int person_id;
    private String person_name;
    private String person_address;
    private String person_email;
    private String person_department;
    private Date person_dob;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_address() {
        return person_address;
    }

    public void setPerson_address(String person_address) {
        this.person_address = person_address;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_department() {
        return person_department;
    }

    public void setPerson_department(String person_department) {
        this.person_department = person_department;
    }

    public Date getPerson_dob() {
        return person_dob;
    }

    public void setPerson_dob(Date person_dob) {
        this.person_dob = person_dob;
    }
}
