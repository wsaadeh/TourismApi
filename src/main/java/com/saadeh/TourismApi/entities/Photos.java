package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_photos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private String photo5;
    private String photo6;
    private String photo7;
    private String photo8;
    private String photo9;
    private String photo10;
    private String photo1Txt;
    private String photo2Txt;
    private String photo3Txt;
    private String photo4Txt;
    private String photo5Txt;
    private String photo6Txt;
    private String photo7Txt;
    private String photo8Txt;
    private String photo9Txt;
    private String photo10Txt;

    @OneToOne
    @MapsId
    private Expedition expedition;
}
