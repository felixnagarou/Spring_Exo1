package com.example.spring_exo1.controllers;

import com.example.spring_exo1.services.GameService;
import com.example.spring_exo1.services.GameServiceClassic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class GameController {

    public final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("game")
    public String startGame(Model model){
        model.addAttribute("");
        model.addAttribute("");
        return "game";
    }



}
