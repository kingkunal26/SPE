package com.kunal.demo.controller;

import com.kunal.demo.entity.Appointments;
import com.kunal.demo.entity.Doctor;
import com.kunal.demo.entity.Patient;
import com.kunal.demo.pojo.AppointmentPojo;
import com.kunal.demo.pojo.DoctorPojo;
import com.kunal.demo.pojo.PatientPojo;

import com.kunal.demo.service.DoctorService;
import com.kunal.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @PutMapping("/register")
    public boolean registerPatient(Patient patient)
    {
        return patientService.registerPatient(patient);
    }

    @PostMapping("/login")
    public int loginPatient(String email,String password)
    {
        return patientService.patientLogin(email, password);
    }

    @GetMapping("/getDoc")
    public List<DoctorPojo> getDoctor()
    {
        return doctorService.getDoctors();
    }

    @PutMapping("/bookAppointment")
    public boolean bookAppointment(int patientId, int doctorId, String date, String time)
    {
        return patientService.bookAppointment(patientId, doctorId, date, time);
    }
    @GetMapping("/getPastAppointments/{patientId}")
    public List<AppointmentPojo> getPastAppointments(@PathVariable int patientId)
    {
        return patientService.getPastAppointments(patientId);
    }
}
