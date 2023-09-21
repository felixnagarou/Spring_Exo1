package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Game;
import com.example.spring_exo1.models.Sentence;
import com.example.spring_exo1.services.GameService;

import com.example.spring_exo1.services.SentenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadavreExquis")
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

    @GetMapping ("/form")
    public String sendGameStateInstruction(Model model){
        model.addAttribute("game", gameService.getGame());
        model.addAttribute("turnCount", gameService.updateTurnCountUntilSentenceFinished());
        model.addAttribute("sentence", sentenceService.getSentence());
        return "/cadavreExquis/game";
    }

    @PostMapping("/addPart")
    public String addSentencePart(String sentencePart){
        sentenceService.editSentence(gameService.getGame().getTurnCount(), sentencePart);
        return "redirect:/form";
    }
}
