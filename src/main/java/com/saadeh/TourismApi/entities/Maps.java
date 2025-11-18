package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_maps")
public class Maps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String map1;
    private String map2;
    private String map3;
    private String map4;
    private String map1Txt;
    private String map2Txt;
    private String map3Txt;
    private String map4Txt;
    @OneToOne
    @MapsId
    private Expedition expedition;
}
