package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@jakarta.persistence.Table(name = "Tables") // El nombre de la tabla debe coincidir con el de SQL
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @OneToMany(mappedBy = "table")
    private List<Guest> guests;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
