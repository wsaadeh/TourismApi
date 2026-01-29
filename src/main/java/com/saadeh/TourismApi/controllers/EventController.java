package com.saadeh.TourismApi.controllers;

import com.saadeh.TourismApi.dto.EventDto;
import com.saadeh.TourismApi.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public Page<EventDto> findAll(Pageable pageable){
        return service.findAll(pageable);
    }
}
