package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Game;
import com.example.spring_exo1.models.Sentence;

import java.util.List;

public interface GameService {

    public int updateTurnCountUntilSentenceFinished();

    public Game getGame();


}
