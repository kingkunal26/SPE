package com.kunal.demo.service;

import com.kunal.demo.entity.Appointments;
import com.kunal.demo.entity.Doctor;
import com.kunal.demo.pojo.AppointmentPojo;
import com.kunal.demo.pojo.DoctorPojo;
import com.kunal.demo.pojo.PatientPojo;
import com.kunal.demo.repository.AppointmentRepo;
import com.kunal.demo.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;
    public boolean registerDoctor(Doctor doctor)
    {

        try {
            doctorRepo.save(doctor);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    public List<DoctorPojo> getDoctors()
    {
        List<Doctor> doctors= doctorRepo.findAll();
        List<DoctorPojo> listDoctorPojo=new ArrayList<>();

        for(Doctor doc:doctors)
        {
            DoctorPojo obj=new DoctorPojo();
            obj.setFname(doc.getFname());
            obj.setLname(doc.getLname());
            obj.setEmail(doc.getEmail());
            obj.setFees(doc.getFees());
//            obj.setId(doc.getDid());
            listDoctorPojo.add(obj);
        }
        return listDoctorPojo;
    }
    public List<Doctor> getAllDoctors()
    {
        return doctorRepo.findAll();
    }

    public int loginDoctor(String email, String password) {
        Doctor d= doctorRepo.findByEmailAndPassword(email,password);
        if(d==null)
            return -1;
        return d.getDid();
    }

    public List<AppointmentPojo> viewAppoinements(int doctorId) {
        try
        {
            Doctor d=doctorRepo.getByDid(doctorId);
            List<Appointments> appointmentsList=appointmentRepo.findAllByDoctor(d);
            List<AppointmentPojo> appointmentPojoList=new ArrayList<>();
            for(Appointments a:appointmentsList)
            {
                AppointmentPojo appointmentPojo=new AppointmentPojo();
                appointmentPojo.setAppid(a.getAppid());
                appointmentPojo.setDate(a.getDate());
                appointmentPojo.setTime(a.getTime());
                DoctorPojo doctorPojo=new DoctorPojo(a.getDoctor());
                appointmentPojo.setDoctorPojo(doctorPojo);
                PatientPojo patientPojo=new PatientPojo(a.getPatient());
                appointmentPojo.setPatientPojo(patientPojo);
                appointmentPojoList.add(appointmentPojo);
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
