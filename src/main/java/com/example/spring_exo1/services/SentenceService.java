package com.example.spring_exo1.services;

import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.models.Sentence;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Primary
public class SentenceService {
    private final Sentence sentence = new Sentence();

    public SentenceService(){
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





    public Sentence getSentence(){
        return sentence;
    }

    public List<String> editSentence(int turnCount, String newPart){
        sentence.setUserInput(newPart);
        List<String> fullSentence = sentence.getParts();
        fullSentence.add(sentence.getUserInput());
       return fullSentence;
    }

}
