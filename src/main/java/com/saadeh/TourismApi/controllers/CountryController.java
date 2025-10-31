package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.CountryDto;
import com.saadeh.TourismApi.dto.CountryMinDto;
import com.saadeh.TourismApi.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    @Autowired
    CountryService service;

    @GetMapping
    public ResponseEntity<Page<CountryDto>> findAll(@RequestParam(name = "name", defaultValue = "") String countryName,
                                                   @RequestParam(name = "continent", defaultValue = "") Long continentId,
                                                   Pageable pageable){
        Page<CountryDto> dto = service.searchAllPaged(countryName,continentId,pageable);
        return ResponseEntity.ok().body(dto);
    }

    
}
