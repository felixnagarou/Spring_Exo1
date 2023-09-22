package com.example.spring_exo1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String pseudo;
    private Date firstLogDate;
    private int numberOfPlayedGames;

}
