package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity(name = "tb_expedition")
@EqualsAndHashCode
public class Expedition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(name = "tb_expedition_event",
    joinColumns = @JoinColumn(name = "expedition_id"),
    inverseJoinColumns = @JoinColumn(name = "event_id"))
    @OrderColumn(name = "event_order")
    private Set<Event> events = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_expedition_hotel",
            joinColumns = @JoinColumn(name = "expedition_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    @OrderColumn(name = "hotel_order")
    private Set<Hotels> hotels = new HashSet<>();

}
