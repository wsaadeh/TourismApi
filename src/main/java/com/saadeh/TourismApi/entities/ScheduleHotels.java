package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_schedule_hotels")
public class ScheduleHotels {

    @EmbeddedId
    private ScheduleHotelsPK id = new ScheduleHotelsPK();

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotels;
}
