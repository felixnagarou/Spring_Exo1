package com.example.spring_exo1.services;

import com.example.spring_exo1.mappers.PlayerMapper;
import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.repositories.PLayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class PlayerService {
    //private  Map<UUID, PlayerDTO> players;
    private final PLayerRepository pLayerRepository;
    private final PlayerMapper playerMapper;

  // public PlayerService(){
  //     this.players = new HashMap<>();


  //     PlayerDTO player1 = PlayerDTO.builder()
  //             .id(UUID.randomUUID())
  //             .pseudo("Doremi")
  //             .years(2)
  //             .numberOfPlayedGames(2)
  //             .build();

  //     PlayerDTO player2 = PlayerDTO.builder()
  //             .id(UUID.randomUUID())
  //             .pseudo("Fassola")
  //             .years(3)
  //             .numberOfPlayedGames(15)
  //             .build();

  //     PlayerDTO player3 = PlayerDTO.builder()
  //             .id(UUID.randomUUID())
  //             .pseudo("Lasido")
  //             .years(0)
  //             .numberOfPlayedGames(3)
  //             .build();

  //     players.put(player1.getId(), player1);
  //     players.put(player2.getId(), player2);
  //     players.put(player3.getId(), player3);


  // }

    public List<PlayerDTO> getPlayers() {
        return pLayerRepository.findAll().stream().map(playerMapper::playerToPlayerDTO).toList();
    }

    public Optional<PlayerDTO> getPlayerById(UUID id) {
        return pLayerRepository.findById(id).stream().map(playerMapper::playerToPlayerDTO).findFirst();
    }
    public List<PlayerDTO> getPlayersSimilarToGivenPseudo(String pseudo) {
        return pLayerRepository.findAllByPseudoStartingWith(pseudo).stream().map(playerMapper::playerToPlayerDTO).toList();
    }
    public List<PlayerDTO> getPlayersBySeniority(Integer seniority) {
        return pLayerRepository.findAllByOrderByFirstLogDateAsc(seniority).stream().map(playerMapper::playerToPlayerDTO).toList();
    }

    public PlayerDTO addPlayer(PlayerDTO playerData) {
      // if (playerData.getId() == null) {
      //     playerData.setId(UUID.randomUUID());
      // }

      // players.put(playerData.getId(), playerData);

      // return playerData;
        return playerMapper.playerToPlayerDTO(pLayerRepository.save(playerMapper.playerDTOToPlayer(playerData)));
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
