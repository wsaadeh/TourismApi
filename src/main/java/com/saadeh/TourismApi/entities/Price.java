package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_price")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private Boolean us_eu;
    private double price;
    private double individual;
    private double triplo;
    private String cia;
    private String embark;
    private int duration;
    private int pessoas;
    private LocalDate datas;
    private String obs1;
    private String obs2;
    private String obs3;

    @OneToOne
    @MapsId
    private Expedition expedition;
}
