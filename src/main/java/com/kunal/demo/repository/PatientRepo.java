package com.kunal.demo.repository;

import com.kunal.demo.entity.Appointments;
import com.kunal.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Integer> {
    public Patient findByEmailAndPassword(String email,String password);
    public Patient getByPid(int pid);


}
