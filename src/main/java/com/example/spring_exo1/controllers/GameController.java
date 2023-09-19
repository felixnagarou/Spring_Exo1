package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Sentence;
import com.example.spring_exo1.models.SentenceDTO;
import com.example.spring_exo1.services.GameService;

import com.example.spring_exo1.services.SentenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    public final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("/index/cadavreExquis")
    public String sendInstruction(Model model){
        model.addAttribute("playerCount", gameService.play());
        model.addAttribute("instruction", gameService.play());
        return "cadavreExquis/game";
    }
}
