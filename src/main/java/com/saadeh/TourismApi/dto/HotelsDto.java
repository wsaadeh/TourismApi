package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.Expedition;
import com.saadeh.TourismApi.entities.Hotels;
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
public class HotelsDto {
    private Long id;
    private String name;
    private int mealPlan;
    private int apartmentType;
    private int category;
    private boolean joker;
    private boolean ok;
    private String address;
    private String ddi;
    private String ddd;
    private String telephone;
    private String fax;
    private String email;
    private String website;
    private String city;
    private String photo1;
    private String photo2;
    private String photo3;
    private Country country;


    public HotelsDto(Hotels entity){
        id = entity.getId();
        name = entity.getName();
        mealPlan = entity.getMealPlan();
        apartmentType = entity.getApartmentType();
        category = entity.getCategory();
        joker = entity.isJoker();
        ok = entity.isOk();
        address = entity.getAddress();
        ddi = entity.getDdi();
        ddd = entity.getDdd();
        telephone = entity.getTelephone();
        fax = entity.getFax();
        email = entity.getEmail();
        website = entity.getWebsite();
        city = entity.getCity();
        photo1 = entity.getPhoto1();
        photo2 = entity.getPhoto2();
        photo3 = entity.getPhoto3();
        country = entity.getCountry();
    }
}
