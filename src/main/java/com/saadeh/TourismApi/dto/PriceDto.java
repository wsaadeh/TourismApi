package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Expedition;
import com.saadeh.TourismApi.entities.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PriceDto {
    private Long id;
    private Boolean us_eu;
    private double price;
    private double individual;
    private double triplo;
    private String cia;
    private String embark;
    private int duration;
    private int pessoas;
    private LocalDate datas;
    private String obs1;
    private String obs2;
    private String obs3;
    private Expedition expedition;

    public PriceDto(Price entity){
        this.id = entity.getId();
        this.us_eu = entity.getUs_eu();
        this.price = entity.getPrice();
        this.individual = entity.getIndividual();
        this.triplo = entity.getTriplo();
        this.cia = entity.getCia();
        this.embark = entity.getEmbark();
        this.duration = entity.getDuration();
        this.pessoas = entity.getPessoas();
        this.datas = entity.getDatas();
        this.obs1 = entity.getObs1();
        this.obs2 = entity.getObs2();
        this.obs3 = entity.getObs3();
        this.expedition = entity.getExpedition();
    }
}
