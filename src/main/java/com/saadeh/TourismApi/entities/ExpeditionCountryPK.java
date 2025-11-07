package com.saadeh.TourismApi.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ExpeditionCountryPK {

    @ManyToOne
    @JoinColumn(name = "expedition_id")
    private Expedition expedition;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
