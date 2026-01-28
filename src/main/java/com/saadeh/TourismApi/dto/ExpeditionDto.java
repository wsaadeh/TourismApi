package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpeditionDto {
    private Long id;
    private Long country_id;
    private String title;
    private boolean title_extra;
    private boolean show_country;
    private int duration;
    private int conditions;
    private LocalDate date;
    private LocalDate creation_date;
    private boolean hide_date;
    private boolean publish;
    private String photo;
    private int im_w;
    private int im_h;
    private String introText;
    private String link_h;
    private boolean link_on_off;
    private boolean hide_date_operator;
    private boolean hotelPublish;
    private LocalDate hotelDay1;
    private boolean hotelDateHide;
    private boolean hotelCatHide;
    private boolean hotelAddressHide;
    private boolean hotelTelHide;
    private boolean hotelEmailHide;
    private boolean hotelWebHide;
    private boolean hotelPhotoHide;
    private boolean hotelColHideDetails;
    private List<Event> events = new ArrayList<>();
    private List<Hotels> hotels = new ArrayList<>();
    private Price price;
    private Maps maps;
    private Photos photos;

    public ExpeditionDto(Expedition entity) {
        id = entity.getId();
        country_id = entity.getCountry_id();
        title = entity.getTitle();
        title_extra = entity.isTitle_extra();
        show_country = entity.isShow_country();
        duration = entity.getDuration();
        conditions = entity.getConditions();
        date = entity.getDate();
        creation_date = entity.getCreation_date();
        hide_date = entity.isHide_date();
        publish = entity.isPublish();
        photo = entity.getPhoto();
        im_w = entity.getIm_w();
        im_h = entity.getIm_h();
        introText = entity.getIntroText();
        link_h = entity.getLink_h();
        link_on_off = entity.isLink_on_off();
        hide_date_operator = entity.isHide_date_operator();
        hotelPublish = entity.isHotelPublish();
        hotelDay1 = entity.getHotelDay1();
        hotelDateHide = entity.isHotelDateHide();
        hotelCatHide = entity.isHotelCatHide();
        hotelAddressHide = entity.isHotelAddressHide();
        hotelTelHide = entity.isHotelTelHide();
        hotelEmailHide = entity.isHotelEmailHide();
        hotelWebHide = entity.isHotelWebHide();
        hotelPhotoHide = entity.isHotelPhotoHide();
        hotelColHideDetails = entity.isHotelColHideDetails();
        events = entity.getEvents();
        hotels = entity.getHotels();
        price = entity.getPrice();
        maps = entity.getMaps();
        photos = entity.getPhotos();
    }
}
