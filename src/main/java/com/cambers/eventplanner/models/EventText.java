package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "Event_Text") // El nombre de la tabla debe coincidir con el de SQL
public class EventText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "TEXT") // Usar columna de tipo TEXT
    private String text;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
