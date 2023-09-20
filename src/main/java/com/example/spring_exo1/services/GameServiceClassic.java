package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Game;
import com.example.spring_exo1.models.Sentence;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
@Profile({"classic", "default"})
public class GameServiceClassic implements GameService{



    //public Sentence sentence;


    //@Override
    //public void play(Sentence sentence) {
    //    Game game = new Game();
    //    for (int i = 0; i <= 3; i++) {
    //        if (sentence.getUserInput() != null) {
    //            sentence.getParts().add(sentence.getUserInput());
    //            game.setTurnCount(i);
    //        }
    //    }
    //}

   //@Override
   //public String getGameState(int turnCount){
   //    return game.getGameState.get(turnCount);
   //}

   //@Override
   //public int getTurnCount() {
   //    return turnCount;
   //}



}
