package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "personal_data")
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String lastname;

    @Size(max = 15)
    private String phoneNumber;

    @Size(max = 255)
    private String address;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Size(max = 255)
    private String photo;

    // Getters y Setters
}
