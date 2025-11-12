package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CountryAttributesPK {

    private Long country; // Should match the type of Country's @Id
    private CountryEnum attribute;

}
