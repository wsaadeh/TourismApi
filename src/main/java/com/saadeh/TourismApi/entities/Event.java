package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean joker;
    private boolean ok;
    private Country country;

}
