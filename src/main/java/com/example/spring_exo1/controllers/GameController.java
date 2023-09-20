package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Game;
import com.example.spring_exo1.services.GameService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    public final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

  //@RequestMapping("/cadavreExquis")
  //public String index(){
  //    return "/cadavreExquis/game";
  //}

    @GetMapping ("/cadavreExquis")
    public String sendGameStateInstruction(Game game, Model model){
        model.addAttribute("game", game);
        return "/cadavreExquis/game";
    }


}
