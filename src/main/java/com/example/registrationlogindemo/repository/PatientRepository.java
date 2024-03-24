package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByEmail(String email);

    boolean existsByEmail(String email); // Custom query method to check if email exists
}
