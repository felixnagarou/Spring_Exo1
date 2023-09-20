package com.example.spring_exo1.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Sentence {

    private UUID uuid;
    private List<String> parts;

    private int counter;

    private String userInput;


    private List<String> partLabels = new ArrayList<>(Arrays.asList("SUJET", "VERBE", "COMPLÉMENT"));

    private String actualPart;

    public Sentence() {
    }

    public Sentence(UUID uuid, List<String> parts, int counter, String userInput, List<String> partLabels, String actualPart) {
        this.uuid = uuid;
        this.parts = parts;
        this.counter = counter;
        this.userInput = userInput;
        this.partLabels = partLabels;
        this.actualPart = actualPart;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }


    public String getUserInput() {
        return userInput;
    }

    public UUID getUuid() {
        return uuid;
    }
}

