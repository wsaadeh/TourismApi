package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.CountryAttributes;
import com.saadeh.TourismApi.entities.CountryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryAttributesDto {
    private Country country;
    private CountryEnum attribute;
    private String description;

    public CountryAttributesDto(CountryAttributes entity){
        country = entity.getCountry();
        attribute = entity.getAttribute();
        description = entity.getDescription();
    }
}
