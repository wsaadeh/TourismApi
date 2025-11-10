package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity(name = "tb_expedition")
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
}
