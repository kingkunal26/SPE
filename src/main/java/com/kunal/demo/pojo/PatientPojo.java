package com.kunal.demo.pojo;

import com.kunal.demo.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientPojo {
    public PatientPojo(Patient patient)
    {
        fname= patient.getFname();
        lname= patient.getLname();
        email= patient.getEmail();
    }
    private String fname;
    private String lname;
    private String email;
//    private String password;
}
