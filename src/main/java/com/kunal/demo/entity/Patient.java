package com.kunal.demo.entity;

import com.kunal.demo.pojo.PatientPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Patient {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int pid;
    private String fname;
    private String lname;
    @Column(unique = true)
    private String email;
    private String password;
}
