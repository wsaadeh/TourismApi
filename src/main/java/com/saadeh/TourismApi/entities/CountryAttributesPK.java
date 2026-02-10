package com.saadeh.TourismApi.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CountryAttributesPK {

    private Long country; // Should match the type of Country's @Id
    private CountryEnum attribute;

}
