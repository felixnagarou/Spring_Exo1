package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Sentence;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Profile({"classic", "default"})
public class GameServiceClassic implements GameService{
    private String userInput;

    private String error;

    public Sentence sentence;


    @Override
    public Sentence play() {
        if (sentence == null) {
            sentence = new Sentence();
        }
        for (int i = 0; i <= 3; i++) {
            if (userInput != null) {
                sentence.getParts().add(userInput);
                sentence.setActualPart(i);
                sentence.setCounter(i);
                return sentence;
            }
        }
        return sentence;
    }
}
