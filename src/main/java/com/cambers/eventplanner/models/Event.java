package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@jakarta.persistence.Table(name = "Events") // El nombre de la tabla debe coincidir con el de SQL
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @Size(max = 255)
    private String address;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @ManyToMany(mappedBy = "events")
    private List<Host> hosts;

    @ManyToMany
    @JoinTable(
            name = "Events_Users",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    @OneToMany(mappedBy = "event")
    private List<EventText> eventTexts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Events_Users",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> guests;

    @OneToMany(mappedBy = "event")
    private List<Table> tables = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<WhatsappMessage> whatsappMessages = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<Program> programs = new ArrayList<>();
}
