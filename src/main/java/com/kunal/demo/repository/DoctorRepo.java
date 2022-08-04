package com.kunal.demo.repository;

import com.kunal.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    public Doctor findByEmailAndPassword(String email,String password);
    public Doctor getByDid(int doctorId);
}
