package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Whatsapp_Messages") // El nombre de la tabla debe coincidir con el de SQL
public class WhatsappMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @Column(name = "send_date")
    private Timestamp sendDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "delivery_status", length = 50)
    private String deliveryStatus;
}
