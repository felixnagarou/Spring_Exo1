package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Game;
import com.example.spring_exo1.models.Sentence;
import com.example.spring_exo1.services.GameService;

import com.example.spring_exo1.services.SentenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    public final GameService gameService;
    public final SentenceService sentenceService;

    public GameController(GameService gameService, SentenceService sentenceService){
        this.gameService = gameService;
        this.sentenceService = sentenceService;
    }

  //@RequestMapping("/cadavreExquis")
  //public String index(){
  //    return "/cadavreExquis/game";
  //}

    @GetMapping ("/cadavreExquis")
    public String sendGameStateInstruction(Model model){

        model.addAttribute("game", new Game());
        model.addAttribute("sentence", new Sentence());
        return "/cadavreExquis/game";
    }

    @PostMapping("/cadavreExquis")
    public String addSentencePart(String sentencePart){
         Sentence sentence = sentenceService.addPart(sentencePart);

        return "/cadavreExquis/game";

    }
}
