package com.example.spring_exo1.services;

import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.models.Sentence;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class SentenceService {
    private final Sentence sentence;

    public SentenceService(){
        sentence = new Sentence();
    }

   // public List<Sentence> getSentences(){
   //     return sentences.values().stream().toList();
   // }

   //public Sentence addUserInputToSentenceParts(){
   //    sentence.getParts().add(sentence.getUserInput());
   //    return sentence;
   //}

   // public Sentence getSentenceByID(UUID id){
   //      return sentences.values().stream().filter(s -> s.getUuid().equals(id)).findFirst().orElse(null);
   // }



    public Sentence addPart(String sentenceData) {
        sentence.setUserInput(sentenceData);
        sentence.getParts().add(sentence.getUserInput());
        return sentence;
    }

}
