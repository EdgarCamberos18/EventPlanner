package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Roles") // El nombre de la tabla debe coincidir con el de SQL
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(name = "show_name")
    private String showName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
