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
    private Sentence sentence;



    @Override
    public Sentence play() {
        sentence = new Sentence();
        for (int counter = 0; counter <= 3; counter++){
            sentence.getParts().add(userInput);
        }
        return sentence;
    }
}
