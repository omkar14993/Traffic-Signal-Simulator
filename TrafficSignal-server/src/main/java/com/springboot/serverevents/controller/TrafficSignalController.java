package com.springboot.serverevents.controller;

import com.springboot.serverevents.service.TrafficSignalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

// Lombok annotation
// Causes lombok to generate a logger field.
@Slf4j
// Spring framework annotation
@RestController
@RequestMapping(value = "/api")
public class TrafficSignalController {

    @Autowired
    TrafficSignalService trafficSignalService;

    // URL - http://localhost:10093/api/signalStatus
    @GetMapping(path = "/signalStatus", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> trafficSignalStream() {
        log.info("Returning the traffic signal events via flux mechanism.");
        return trafficSignalService.sendNextLightStatus();
    }
}
