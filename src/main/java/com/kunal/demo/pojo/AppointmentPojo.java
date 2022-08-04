package com.kunal.demo.pojo;

import com.kunal.demo.entity.Doctor;
import com.kunal.demo.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentPojo {
    private int appid;
    private PatientPojo patientPojo;

    private DoctorPojo doctorPojo;
    private Date date;
    private Date time;
}
