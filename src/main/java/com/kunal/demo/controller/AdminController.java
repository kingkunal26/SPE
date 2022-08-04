package com.kunal.demo.controller;

import com.kunal.demo.entity.Doctor;
import com.kunal.demo.entity.Patient;
import com.kunal.demo.pojo.AppointmentPojo;
import com.kunal.demo.service.AdminService;
import com.kunal.demo.service.DoctorService;
import com.kunal.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AdminService adminService;
    @PutMapping("/adddoc")
    public boolean addDoc(Doctor doc)
    {
        return doctorService.registerDoctor(doc);
    }
    @PostMapping("/login")
    public int loginAdmin(String email,String password)
    {
        return adminService.loginAdmin(email, password);
    }
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors()
    {
        return doctorService.getAllDoctors();
    }
    @GetMapping("/getPatients")
    public List<Patient> getAllPatients()
    {
        return patientService.getPatients();
    }

    @GetMapping("/appointments")
    public List<AppointmentPojo> appointments()
    {
        return adminService.appointments();
    }
}
