package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Sentence;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
@Profile({"classic", "default"})
public class GameServiceClassic implements GameService{


    private String error;

    private int turnCount;

    private String userInput;

    private List<String> gameState = new ArrayList<>(Arrays.asList("SUJET", "VERBE", "COMPLEMENT"));

    //public Sentence sentence;


    @Override
    public String play(Sentence sentence) {
        for (turnCount= 0; turnCount <= 3; turnCount++) {
            if (userInput != null) {
                sentence.getParts().add(userInput);
                return sentence;
            }
        }
        return sentence;
    }

    public void setGameState(int turnCount){

    }


}
