package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "host")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private String password;

    private Boolean enabled;

    @OneToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;

    @ManyToMany
    private List<Event> events;

    // Getters y Setters
}
