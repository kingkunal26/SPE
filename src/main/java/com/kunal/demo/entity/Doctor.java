package com.kunal.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int did;
    private String fname;
    private String lname;
    @Column(unique = true)
    private String email;
    private String password;
    private int fees;

    @Override
    public String toString() {
        return "Doctor{" +
                "did=" + did +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fees=" + fees +
                '}';
    }
}
