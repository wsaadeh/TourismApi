package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.HotelsDto;
import com.saadeh.TourismApi.services.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/hotels")
public class HotelsController {

    @Autowired
    private HotelsService service;

    @GetMapping
    public ResponseEntity<Page<HotelsDto>> findAll(Pageable pageable){
        Page<HotelsDto> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HotelsDto> findById(@PathVariable Long id){
        HotelsDto result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<HotelsDto> insert(@RequestBody HotelsDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HotelsDto> update(@PathVariable Long id,@RequestBody HotelsDto dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
