package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Sentence;

import java.util.List;

public interface GameService {
   public void play(Sentence sentence);

   public String getGameState(int i);

   public int getTurnCount();


}
