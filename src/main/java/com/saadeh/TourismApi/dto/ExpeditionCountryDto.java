package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.ExpeditionCountry;
import com.saadeh.TourismApi.entities.ExpeditionCountryPK;
import com.saadeh.TourismApi.entities.Selo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpeditionCountryDto {

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

    public ExpeditionCountryDto(ExpeditionCountry entity) {
        id = entity.getId();
        icon_elephant = entity.isIcon_elephant();
        icon_canoe = entity.isIcon_canoe();
        icon_beach = entity.isIcon_beach();
        icon_jeep = entity.isIcon_jeep();
        icon_jeep2 = entity.isIcon_jeep2();
        icon_mountain = entity.isIcon_mountain();
        icon_boat = entity.isIcon_boat();
        icon_train = entity.isIcon_train();
        icon_trekking = entity.isIcon_trekking();
        icon_scuba = entity.isIcon_scuba();
        icon_bike = entity.isIcon_bike();
        icon_bus = entity.isIcon_bus();
        icon_selo = entity.getIcon_selo();

    }
}
