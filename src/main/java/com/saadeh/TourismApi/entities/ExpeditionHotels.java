package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_expedition_hotels")
public class ExpeditionHotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private boolean publish;
    private LocalDate day1;
    private boolean hotel_date_hide;
    private boolean cat_hide;
    private boolean address_hide;
    private boolean tel_hide;
    private boolean email_hide;
    private boolean web_hide;
    private boolean photo_hide;
    private boolean col_hide_details;

}
