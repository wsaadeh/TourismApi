package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;


}
