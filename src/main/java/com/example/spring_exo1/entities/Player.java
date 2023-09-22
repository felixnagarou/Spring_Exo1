package com.example.spring_exo1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String pseudo;
    private LocalDate firstLogDate;
    private int numberOfPlayedGames;

    public Player(){
        this.firstLogDate = LocalDate.now();
    }

}
