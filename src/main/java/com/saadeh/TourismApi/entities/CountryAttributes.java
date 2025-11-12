package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_country_attributes")
@IdClass(CountryAttributesPK.class)
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
