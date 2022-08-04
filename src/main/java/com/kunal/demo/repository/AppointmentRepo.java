package com.kunal.demo.repository;

import com.kunal.demo.entity.Appointments;
import com.kunal.demo.entity.Doctor;
import com.kunal.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepo extends JpaRepository<Appointments,Integer> {
    public boolean existsByDoctorIsAndDateAndTime(Doctor doctor, Date date, Date time);
    public List<Appointments> findAllByPatient(Patient p);
    public List<Appointments> findAllByDoctor(Doctor d);
}
