package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mobile")
    private String mobile;

    // Store hashed password
    @Column(name = "Password")
    private String hashedPassword;

    // Constructor with hashed password
    public Patient(String firstName, String lastName, String email, String mobile, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        setPassword(password); // Hash the password
    }

    // Setter for password, automatically hashes the password
    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.hashedPassword = passwordEncoder.encode(password);
    }
}
