package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Continent;
import com.saadeh.TourismApi.entities.Language;

public class ContinentDto {

    private Long id;

    private String name;

    private Language language;

    public ContinentDto() {
    }

    public ContinentDto(Long id, String name, Language language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public ContinentDto(Continent entity) {
        id = entity.getId();
        name = entity.getName();
        language = entity.getLanguage();
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
}
