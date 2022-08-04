package com.kunal.demo.repository;

import com.kunal.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    public Admin findByEmailAndPassword(String email,String password);
}
