package com.saadeh.TourismApi.controllers.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardException{
    private List<FieldMessage> errors = new ArrayList<>();
    public void addError(String fieldName,String message){
        errors.add(new FieldMessage(fieldName, message));
    }
}
