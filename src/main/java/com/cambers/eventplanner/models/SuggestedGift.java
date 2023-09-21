package com.cambers.eventplanner.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Suggested_Gifts") // El nombre de la tabla debe coincidir con el de SQL
public class SuggestedGift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "required_quantity")
    private Integer requiredQuantity;

    private String url;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
