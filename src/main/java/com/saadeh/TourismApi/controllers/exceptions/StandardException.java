package com.saadeh.TourismApi.controllers.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class StandardException {
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
