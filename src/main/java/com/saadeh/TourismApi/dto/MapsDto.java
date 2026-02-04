package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Expedition;
import com.saadeh.TourismApi.entities.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MapsDto {
    private Long id;
    private String map1;
    private String map2;
    private String map3;
    private String map4;
    private String map1Txt;
    private String map2Txt;
    private String map3Txt;
    private String map4Txt;
    private Long expeditionId;


    public MapsDto(Maps entity){
        id = entity.getId();
        map1 = entity.getMap1();
        map2 = entity.getMap2();
        map3 = entity.getMap3();
        map4 = entity.getMap4();
        map1Txt = entity.getMap1Txt();
        map2Txt = entity.getMap3Txt();
        map3Txt = entity.getMap3Txt();
        map4Txt = entity.getMap4Txt();
        expeditionId = entity.getExpedition().getId();
    }
}
