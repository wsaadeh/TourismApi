package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.MapsDto;
import com.saadeh.TourismApi.services.MapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/maps")
public class MapsController {

    @Autowired
    private MapsService service;

    @GetMapping
    public Page<MapsDto> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public MapsDto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<MapsDto> insert(@RequestBody MapsDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MapsDto> update(@PathVariable Long id, @RequestBody MapsDto dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
