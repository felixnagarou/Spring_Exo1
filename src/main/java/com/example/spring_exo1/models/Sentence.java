package com.example.spring_exo1.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Sentence {


    private List<String> parts;
    private String userInput;


    public Sentence() {
        this.parts = new ArrayList<>();
        this.userInput = null;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public String getUserInput() {
        return userInput;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }



}

