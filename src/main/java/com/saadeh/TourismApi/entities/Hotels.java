package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private int mealPlan;
    private int apartmentType;
    private int category;
    private boolean joker;
    private boolean ok;
    private String address;
    private String ddi;
    private String ddd;
    private String telephone;
    private String fax;
    private String email;
    private String website;
    private String city;
    private String photo1;
    private String photo2;
    private String photo3;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany(mappedBy = "hotels")
    Set<Expedition> expeditions = new HashSet<>();

}
