package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Sentence;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class SentenceService {
    private final Map<UUID, Sentence> sentences;

    public SentenceService(){
        sentences = new HashMap<>();
    }

    public List<Sentence> getSentences(){
        return sentences.values().stream().toList();
    }

    public Sentence addUserInputToSentenceParts(){
        Sentence sentence = new Sentence();
        sentence.getParts().add(sentence.getUserInput());
        return sentence;
    }

    public Sentence getSentenceByID(UUID id){
         return sentences.values().stream().filter(s -> s.getUuid().equals(id)).findFirst().orElse(null);
    }

}
