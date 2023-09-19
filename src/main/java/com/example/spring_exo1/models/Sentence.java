package com.example.spring_exo1.models;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<String> parts;



    private int counter;
    public List<String> partLabel = List.of("SUJET", "VERBE", "COMPLÉMENT");

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

    public List<String> getPartLabel() {
        return partLabel;
    }
}
