package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.CountryDto;
import com.saadeh.TourismApi.dto.CountryMinDto;
import com.saadeh.TourismApi.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    @Autowired
    CountryService service;

    @GetMapping
    public ResponseEntity<Page<CountryDto>> findAll(@RequestParam(name = "name", defaultValue = "") String countryName,
                                                   @RequestParam(name = "continent", required = false) Long continentId,
                                                   Pageable pageable){
        Page<CountryDto> dto = service.searchAllPaged(countryName,continentId,pageable);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CountryDto> insert(@RequestBody CountryDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CountryDto> update(@PathVariable Long id,@RequestBody CountryDto dto){
        dto = service.update(id,dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CountryDto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }






}
