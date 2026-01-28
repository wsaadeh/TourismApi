package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Expedition;
import com.saadeh.TourismApi.entities.Photos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotosDto {
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
    private Expedition expedition;

    public PhotosDto(Photos entity){
        id = entity.getId();
        photo1 = entity.getPhoto1();
        photo2 = entity.getPhoto2();
        photo3 = entity.getPhoto3();
        photo4 = entity.getPhoto4();
        photo5 = entity.getPhoto5();
        photo6 = entity.getPhoto6();
        photo7 = entity.getPhoto7();
        photo8 = entity.getPhoto8();
        photo9 = entity.getPhoto9();
        photo10 = entity.getPhoto10();
        photo1Txt = entity.getPhoto1Txt();
        photo2Txt = entity.getPhoto2Txt();
        photo3Txt = entity.getPhoto3Txt();
        photo4Txt = entity.getPhoto4Txt();
        photo5Txt = entity.getPhoto5Txt();
        photo6Txt = entity.getPhoto6Txt();
        photo7Txt = entity.getPhoto7Txt();
        photo8Txt = entity.getPhoto8Txt();
        photo9Txt = entity.getPhoto9Txt();
        photo10Txt = entity.getPhoto10Txt();
        expedition = entity.getExpedition();
    }

}
