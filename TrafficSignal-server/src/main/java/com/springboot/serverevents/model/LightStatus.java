package com.springboot.serverevents.model;

public enum LightStatus {
    RED("RED"), GREEN("GREEN"), YELLOW("YELLOW");

    public final String value;

    private LightStatus(String value) {
        this.value = value;
    }
}
