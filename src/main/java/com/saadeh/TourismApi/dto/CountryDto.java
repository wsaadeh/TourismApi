package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Continent;
import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.Language;


public class CountryDto {

    private Long id;

    private String name;

    private Language language;

    private Continent continent;

    public CountryDto(){}

    public CountryDto(Long id, String name, Language language, Continent continent) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.continent = continent;
    }

    public CountryDto(Country entity) {
        id = entity.getId();
        name = entity.getName();
        language = entity.getLanguage();
        continent = entity.getContinent();
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
