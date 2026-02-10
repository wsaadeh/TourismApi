package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.CountryAttributesDto;
import com.saadeh.TourismApi.entities.CountryAttributes;
import com.saadeh.TourismApi.entities.CountryAttributesPK;
import com.saadeh.TourismApi.entities.CountryEnum;
import com.saadeh.TourismApi.services.CountryAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/country-attributes")
public class CountryAttributesController {

    @Autowired
    private CountryAttributesService service;

    @GetMapping
    public ResponseEntity<Page<CountryAttributesDto>> findAll(Pageable pageable){
        Page<CountryAttributesDto> pageDto = service.findAll(pageable);
        return ResponseEntity.ok().body(pageDto);
    }

    @GetMapping(value = "/{countryId}/{attribute}")
    public ResponseEntity<CountryAttributesDto> findById(
            @PathVariable long countryId,
            @PathVariable CountryEnum attribute){

        CountryAttributesPK id = new CountryAttributesPK(countryId,attribute);
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CountryAttributesDto> insert(@RequestBody CountryAttributesDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{countryId}/{attribute}")
                .buildAndExpand(dto.getCountry().getId(),dto.getAttribute())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{countryId}/{attribute}")
    public ResponseEntity<CountryAttributesDto> update(@PathVariable Long countryId,@PathVariable String attribute, @RequestBody CountryAttributesDto dto){
        dto = service.update(countryId,attribute,dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{countryId}/{attribute}")
    public ResponseEntity<Void> delete(@PathVariable Long countryId,@PathVariable String attribute){
        service.delete(countryId,attribute);
        return ResponseEntity.noContent().build();
    }
}
