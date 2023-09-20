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

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setActualPart(int i) {
        actualPart = partLabels.get(i);
    }

    public String getActualPart() {
        return actualPart;
    }
    //public List<String> getPartLabels() {
    //  return partLabels;
    //}


    public String getUserInput() {
        return userInput;
    }

    public UUID getUuid() {
        return uuid;
    }
}

