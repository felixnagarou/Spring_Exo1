package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Sentence;
import com.example.spring_exo1.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SentenceController {
    private final GameService gameService;

    public SentenceController(GameService gameService) {this.gameService = gameService};


}
