package com.example.spring_exo1.models;

import java.util.List;

public class Sentence {
    private List<String> parts;

    private String partName;
    public enum partName {
        SUJET,
        VERBE,
        COMPLEMENT;
    }

    public Sentence() {
    }
    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public String getPartName() {

        return partName;
    }
}
