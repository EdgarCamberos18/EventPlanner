package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@jakarta.persistence.Table(name = "guests") // El nombre de la tabla debe coincidir con el de SQL
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Email
    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    private Integer seat;

    private Integer occupiedSeats;
}
