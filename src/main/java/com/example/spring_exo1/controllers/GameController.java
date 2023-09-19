package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Sentence;
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

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("/index/cadavreExquis")
    public String sendInstruction(Model model){
        model.addAttribute("playerCount",gameService.play().getCounter());
        model.addAttribute("instruction", gameService.play().getActualPart());
        return "cadavreExquis/game";
    }

    @PostMapping("/cadavreExquis")
    public String getUserInput(@ModelAttribute Sentence sentence, Model model){
        model.addAttribute();


    }

    @GetMapping("/endGame")
    public String endGameRedirect(Model model){
        model.addAttribute("fullSentence", );

    }







}
