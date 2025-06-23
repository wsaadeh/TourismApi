package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.ContinentDto;
import com.saadeh.TourismApi.entities.Continent;
import com.saadeh.TourismApi.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/continents")
public class ContinentController {
    @Autowired
    private ContinentService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContinentDto> findById(@PathVariable Long id){
        ContinentDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ContinentDto>> findAll(){
        List<ContinentDto> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ContinentDto> insert(@RequestBody ContinentDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContinentDto> update(@PathVariable Long id,@RequestBody ContinentDto dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ContinentDto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
