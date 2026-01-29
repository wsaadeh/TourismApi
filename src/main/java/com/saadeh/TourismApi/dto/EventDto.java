package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.Event;
import com.saadeh.TourismApi.entities.Expedition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private boolean joker;
    private boolean ok;
    private Country country;


    public EventDto(Event entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        joker = entity.isJoker();
        ok = entity.isJoker();
        country = entity.getCountry();

    }
}
