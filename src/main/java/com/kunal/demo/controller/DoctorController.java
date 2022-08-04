package com.kunal.demo.controller;

import com.kunal.demo.pojo.AppointmentPojo;
import com.kunal.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/login")
    public int loginDoctor(String email,String password)
    {
        return doctorService.loginDoctor(email,password);
    }

    @GetMapping("/viewAppoinements/{doctorId}")
    public List<AppointmentPojo> viewAppoinements(@PathVariable int doctorId)
    {
        return doctorService.viewAppoinements(doctorId);
    }
}
