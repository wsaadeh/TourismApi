package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryMinDto {
    private Long id;

    private String name;

    private Language language;

    private String continent;

    public CountryMinDto(Country entity){
        id = entity.getId();
        name = entity.getName();
        language = entity.getLanguage();
        continent = entity.getContinent().getName();
    }

}
