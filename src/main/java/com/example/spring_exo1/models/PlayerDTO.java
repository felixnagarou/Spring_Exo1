package com.example.spring_exo1.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class PlayerDTO {
    private UUID id;
    private String pseudo;
    private Date firstLogDate;
    private int numberOfPlayedGames;
}
