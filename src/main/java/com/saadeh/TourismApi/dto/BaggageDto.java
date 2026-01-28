package com.saadeh.TourismApi.dto;

import com.saadeh.TourismApi.entities.Baggage;
import com.saadeh.TourismApi.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaggageDto {
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
    private Country country;

    public BaggageDto(Baggage entity){
        id = entity.getId();
        i1 = entity.isI1();
        i2 = entity.isI12();
        i3 = entity.isI3();
        i4 = entity.isI4();
        i5 = entity.isI15();
        i6 = entity.isI6();
        i7 = entity.isI17();
        i8 = entity.isI8();
        i9 = entity.isI9();
        i10 = entity.isI10();
        i11 = entity.isI11();
        i12 = entity.isI12();
        i13 = entity.isI13();
        i14 = entity.isI14();
        i15 = entity.isI15();
        i16 = entity.isI16();
        i17 = entity.isI17();
        i18 = entity.isI18();
        i19 = entity.isI19();
        i20 = entity.isI20();
        i21 = entity.isI21();
        i22 = entity.isI22();
        i23 = entity.isI23();
        i24 = entity.isI24();
        i25 = entity.isI25();
        i26 = entity.isI26();
        i27 = entity.isI27();
        i28 = entity.isI28();
        i29 = entity.isI29();
        i30 = entity.isI30();
        country = entity.getCountry();
    }
}
