package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_country_attributes")
@IdClass(CountryAttributesPK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryAttributes {

    @Id
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "attribute_id")
    private CountryEnum attribute;

    @Column(columnDefinition = "TEXT")
    private String description;
}
