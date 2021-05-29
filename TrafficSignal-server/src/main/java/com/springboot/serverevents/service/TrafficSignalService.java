package com.springboot.serverevents.service;

import com.springboot.serverevents.model.LightStatus;
import com.springboot.serverevents.repo.TrafficSignalRepository;

import org.springframework.http.codec.ServerSentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

// Lombok annotation
// Causes lombok to generate a logger field.
@Slf4j
// Spring framework annotation
@Service
public class TrafficSignalService {

    @Autowired
    TrafficSignalRepository trafficSignalRepository;

    public Flux<ServerSentEvent<String>> sendNextLightStatus() {
        log.info("Getting current light status");
        return trafficSignalRepository.generateSignalLights();

    }
}
