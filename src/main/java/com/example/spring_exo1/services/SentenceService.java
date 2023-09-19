package com.example.spring_exo1.services;

import com.example.spring_exo1.models.SentenceDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class SentenceService {
    private final Map<UUID, SentenceDTO> sentences;

    public SentenceService(){
        sentences = new HashMap<>();
    }

    public List<SentenceDTO> getSentences(){
        return sentences.values().stream().toList();
    }

    public SentenceDTO getSentenceByID(UUID id){
         return sentences.values().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

}
