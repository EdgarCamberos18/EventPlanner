package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "Programs") // El nombre de la tabla debe coincidir con el de SQL
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_time")
    private Time startTime;
}
