package com.example.spring_exo1.services;

import com.example.spring_exo1.models.PlayerDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PlayerService {
    private  Map<UUID, PlayerDTO> players;

    public PlayerService(){
        this.players = new HashMap<>();

        PlayerDTO player1 = PlayerDTO.builder()
                .id(UUID.randomUUID())
                .pseudo("Doremi")
                .firstLogDate(null)
                .numberOfPlayedGames(0)
                .build();

        PlayerDTO player2 = PlayerDTO.builder()
                .id(UUID.randomUUID())
                .pseudo("Fassola")
                .firstLogDate(null)
                .numberOfPlayedGames(0)
                .build();

        PlayerDTO player3 = PlayerDTO.builder()
                .id(UUID.randomUUID())
                .pseudo("Lasido")
                .firstLogDate(null)
                .numberOfPlayedGames(0)
                .build();

        players.put(player1.getId(), player1);
        players.put(player2.getId(), player2);
        players.put(player3.getId(), player3);


    }

    public List<PlayerDTO> getPlayers() {
        return players.values().stream().toList();
    }

    public Optional<PlayerDTO> getPlayerById(UUID id) {
        return players.values().stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public Optional<PlayerDTO> getPlayerByPseudo(String pseudo) {
        return players.values().stream().filter(p -> p.getPseudo().equals(pseudo)).findFirst();
    }
    public Optional<PlayerDTO> getPlayerBySeniority(Date seniority) {
        return players.values().stream().filter(p -> p.getFirstLogDate().equals(seniority)).findFirst();
    }

    public PlayerDTO addPlayer(PlayerDTO playerData) {
        if (playerData.getId() == null) {
            playerData.setId(UUID.randomUUID());
        }

        players.put(playerData.getId(), playerData);

        return playerData;
    }

    public Boolean deletePlayerById(UUID id){
        Optional<PlayerDTO> foundPlayer = getPlayerById(id);

        if (foundPlayer.isPresent()){
            players.remove(foundPlayer.get().getId());
            return true;
        }
        return false;

    }

    public PlayerDTO changePlayerPseudo(UUID id, PlayerDTO newPseudo){
        AtomicReference<PlayerDTO> atomicReference = new AtomicReference<>();

        Optional<PlayerDTO> foundPlayer = getPlayerById(id);

        foundPlayer.ifPresentOrElse(found -> {
            if (newPseudo.getPseudo() != null) {
                found.setPseudo(newPseudo.getPseudo());
            }
            atomicReference.set(found);
        }, () -> {
            atomicReference.set(null);
        });
        return atomicReference.get();
    }
}
