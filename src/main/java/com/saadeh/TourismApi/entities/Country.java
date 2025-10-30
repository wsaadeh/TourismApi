package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Language language;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent countryContinent;

    public Country() {
    }

    public Country(Long id, String name, Continent countryContinent, Language language) {
        this.id = id;
        this.name = name;
        this.countryContinent = countryContinent;
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
        return countryContinent;
    }

    public void setContinent(Continent countryContinent) {
        this.countryContinent = countryContinent;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
