package com.saadeh.TourismApi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_baggage")
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean i1;
    private boolean i2;
    private boolean i3;
    private boolean i4;
    private boolean i5;
    private boolean i6;
    private boolean i7;
    private boolean i8;
    private boolean i9;
    private boolean i10;
    private boolean i11;
    private boolean i12;
    private boolean i13;
    private boolean i14;
    private boolean i15;
    private boolean i16;
    private boolean i17;
    private boolean i18;
    private boolean i19;
    private boolean i20;
    private boolean i21;
    private boolean i22;
    private boolean i23;
    private boolean i24;
    private boolean i25;
    private boolean i26;
    private boolean i27;
    private boolean i28;
    private boolean i29;
    private boolean i30;

    @OneToOne
    @MapsId
    private Country country;
}
