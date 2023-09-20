package com.example.spring_exo1.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private String error;

    private int turnCount;


    private List<String> gameState = new ArrayList<>(Arrays.asList("SUJET", "VERBE", "COMPLEMENT"));


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public List<String> getGameState() {
        return gameState;
    }

    public void setGameState(List<String> gameState) {
        this.gameState = gameState;
    }
}
