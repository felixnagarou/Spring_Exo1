package com.example.spring_exo1.controllers;

import com.example.spring_exo1.exceptions.RessourceNotFoundException;
import com.example.spring_exo1.models.Sentence;
import com.example.spring_exo1.services.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sentences")
public class GameRestController {
    private final SentenceService sentenceService;

    @GetMapping("/sentenceList")
    public List<Sentence> sentenceList(){
        return sentenceService.getSentences();
    }

    //@GetMapping("/sentenceList")
    //public ResponseEntity<Sentence> getSentenceById(UUID uuid){
    //    Sentence found = sentenceService.getSentenceByID(uuid);
    //    if (found != null){
    //        return ResponseEntity.ok(found);
    //    } else {
    //        throw new RessourceNotFoundException();
    //    }
    //}



    //throw new RessourceNotFoundException();


}
