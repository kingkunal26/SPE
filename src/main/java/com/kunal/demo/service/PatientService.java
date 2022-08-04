package com.kunal.demo.service;

import com.kunal.demo.entity.Appointments;
import com.kunal.demo.entity.Doctor;
import com.kunal.demo.entity.Patient;
import com.kunal.demo.pojo.AppointmentPojo;
import com.kunal.demo.pojo.DoctorPojo;
import com.kunal.demo.pojo.PatientPojo;
import com.kunal.demo.repository.AppointmentRepo;
import com.kunal.demo.repository.DoctorRepo;
import com.kunal.demo.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    DoctorRepo doctorRepo;

    public boolean registerPatient(Patient patient)
    {

        try {
            patientRepo.save(patient);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public int patientLogin(String email,String password)
    {
        Patient p= patientRepo.findByEmailAndPassword(email, password);
        if(p == null)
        {
            return -1;
        }
        return p.getPid();
    }

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public boolean bookAppointment(int patientId, int doctorId, String date, String time) {

        try {
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Date time1=new SimpleDateFormat("HH:mm").parse(time);
            Patient p=patientRepo.getById(patientId);
            Doctor d=doctorRepo.getById(doctorId);
            if(appointmentRepo.existsByDoctorIsAndDateAndTime(d,date1,time1))
            {
                return false;
            }

            Appointments a=new Appointments();
            a.setPatient(p);
            a.setDoctor(d);
            a.setDate(date1);
            a.setTime(time1);
            appointmentRepo.save(a);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<AppointmentPojo> getPastAppointments(int patientId) {
        try
        {
            Patient p=patientRepo.getByPid(patientId);
            List<Appointments> appoints=appointmentRepo.findAllByPatient(p);
            List<AppointmentPojo> appointPojo=new ArrayList<>();
            for(Appointments a:appoints)
            {
                AppointmentPojo ap=new AppointmentPojo();
                ap.setDate(a.getDate());
                ap.setAppid(a.getAppid());
                ap.setTime(a.getTime());
                PatientPojo pp=new PatientPojo(a.getPatient());
                ap.setPatientPojo(pp);
                DoctorPojo dp=new DoctorPojo(a.getDoctor());
                ap.setDoctorPojo(dp);
                appointPojo.add(ap);
            }
            return appointPojo;
        }
        catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
}
