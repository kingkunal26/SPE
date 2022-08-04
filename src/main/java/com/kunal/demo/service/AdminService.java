package com.kunal.demo.service;

import com.kunal.demo.entity.Admin;
import com.kunal.demo.entity.Appointments;
import com.kunal.demo.entity.Doctor;
import com.kunal.demo.pojo.AppointmentPojo;
import com.kunal.demo.pojo.DoctorPojo;
import com.kunal.demo.pojo.PatientPojo;
import com.kunal.demo.repository.AdminRepo;
import com.kunal.demo.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;
    public int loginAdmin(String email,String password)
    {
        Admin a= adminRepo.findByEmailAndPassword(email,password);
        if(a==null)
            return -1;
        return a.getAid();
    }

    public List<AppointmentPojo> appointments() {
        try
        {
            List<AppointmentPojo> appointmentPojoList=new ArrayList<>();
            List<Appointments> appointmentsList=appointmentRepo.findAll();
            for(Appointments a:appointmentsList)
            {
                AppointmentPojo ap=new AppointmentPojo();
                ap.setAppid(a.getAppid());
                ap.setTime(a.getTime());
                ap.setDate(a.getDate());
                DoctorPojo dp=new DoctorPojo(a.getDoctor());
                ap.setDoctorPojo(dp);
                PatientPojo pp=new PatientPojo(a.getPatient());
                ap.setPatientPojo(pp);
                appointmentPojoList.add(ap);
            }
            return appointmentPojoList;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
}
