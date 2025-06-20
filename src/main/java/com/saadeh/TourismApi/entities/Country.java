package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Language language;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    public Country() {
    }

    public Country(Long id, String name, Continent continent, Language language) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
