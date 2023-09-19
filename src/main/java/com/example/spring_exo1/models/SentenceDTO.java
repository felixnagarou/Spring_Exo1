package com.example.spring_exo1.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class SentenceDTO {
    private UUID id;
    private String content;

}
