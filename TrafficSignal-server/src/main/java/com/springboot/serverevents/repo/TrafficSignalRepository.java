package com.springboot.serverevents.repo;

import com.github.javafaker.Faker;
import com.springboot.serverevents.model.LightStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Slf4j

@Repository
public class TrafficSignalRepository {
    LightStatus currentState = LightStatus.RED;

    public Flux<ServerSentEvent<String>> generateSignalLights() {
        log.info("generateSignalLights");
        // Simulate the data streaming every 4 seconds.
        return Flux.interval(Duration.ofSeconds(4))
                .map(sequence -> ServerSentEvent.<String> builder()
                    .id(String.valueOf(sequence))
                    .event("signal-status-stream")
                    .data(this.getNextState(this.currentState).toString())
                    .build());
    }

    public LightStatus getNextState(LightStatus currentState) {
        log.info("getting next state");
        LightStatus nextState;
        switch(currentState) {
            case RED : nextState = LightStatus.GREEN;
                       break;

            case YELLOW : nextState = LightStatus.RED;
                          break;

            case GREEN : nextState = LightStatus.YELLOW;
                         break;

            default : nextState = LightStatus.RED;
        }

        this.currentState = nextState;
        return nextState;
    }
}
