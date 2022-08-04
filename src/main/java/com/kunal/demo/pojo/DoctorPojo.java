package com.kunal.demo.pojo;

import com.kunal.demo.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPojo {
    public DoctorPojo(Doctor doctor)
    {
        fname=doctor.getFname();
        lname= doctor.getLname();
        email=doctor.getEmail();
        fees= doctor.getFees();
    }
//    private int id;
    private String fname;
    private String lname;
    private String email;
    private int fees;
}
