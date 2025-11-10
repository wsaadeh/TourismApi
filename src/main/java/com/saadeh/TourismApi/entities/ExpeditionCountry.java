package com.saadeh.TourismApi.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_expedition_country")
public class ExpeditionCountry {

    @EmbeddedId
    private ExpeditionCountryPK id = new ExpeditionCountryPK();

    private boolean icon_elephant;
    private boolean icon_canoe;
    private boolean icon_beach;
    private boolean icon_jeep;
    private boolean icon_jeep2;
    private boolean icon_mountain;
    private boolean icon_boat;
    private boolean icon_train;
    private boolean icon_trekking;
    private boolean icon_scuba;
    private boolean icon_bike;
    private boolean icon_bus;
    //According to choice 0-blank(no choice made),1-group,2-premium,3-excellence
    private Selo icon_selo;

}
