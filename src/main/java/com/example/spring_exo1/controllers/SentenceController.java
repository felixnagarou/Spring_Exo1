package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.Sentence;
import com.example.spring_exo1.services.SentenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SentenceController {

    public final SentenceService sentenceService;

    public SentenceController(SentenceService sentenceService){
        this.sentenceService = sentenceService;
    }




    @GetMapping("/cadavreExquis/game")
    public String createSentence(Model model){
        model.addAttribute("sentence", new Sentence());
        return "/cadavreExquis/game";
    }



    @PostMapping("/cadavreExquis")
    public String setSentence(@ModelAttribute Sentence sentence, Model model){
        model.addAttribute("sentence", sentence);
        return "redirect:cadavreExquis/game";
    }
}
