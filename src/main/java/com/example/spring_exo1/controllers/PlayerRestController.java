package com.example.spring_exo1.controllers;

import com.example.spring_exo1.exceptions.RessourceNotFoundException;
import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.services.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/players")
@RequiredArgsConstructor
@Slf4j
public class PlayerRestController {
    private final PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> listPLayer(@RequestParam(value = "pseudo", defaultValue = "") String filterByPseudo){
        List<PlayerDTO> players = playerService.getPlayers();

        if (!filterByPseudo.isEmpty() && !filterByPseudo.isBlank()) {
            players = players.stream().filter(p -> p.getPseudo().startsWith(filterByPseudo)).toList();
        }
        return players;
    }

    @GetMapping("/{playerId}")
    public PlayerDTO getPlayerDetails(@PathVariable("playerId") UUID id){
        PlayerDTO playerDTO = playerService.getPlayerById(id);
        if(playerDTO != null){
            return playerDTO;
        }
        throw  new RessourceNotFoundException();
    }

    @PostMapping("/add")
    public  ResponseEntity<String> addPlayerHandler(@RequestBody PlayerDTO newPlayer){
        PlayerDTO dto = playerService.addPlayer(newPlayer);

        return new ResponseEntity<String>("Player was added, new id: " + dto.getId(), HttpStatus.CREATED);
    }



    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayerById(@PathVariable("playerId") UUID id) {
        PlayerDTO dto = playerService.getPlayerById(id);

        if (dto != null) {
            if (playerService.deletePlayerById(id)) {
                return new ResponseEntity<String>("Player was deleted at id : " + id, HttpStatus.OK);
            }
            return new ResponseEntity<String>("Error while trying to delete player", HttpStatus.NOT_MODIFIED);
        } else {
            throw new RessourceNotFoundException();
        }
    }

    @PatchMapping("/{playerId")
    public  PlayerDTO editPlayer(@PathVariable("playerId") UUID id, @RequestBody PlayerDTO playerData) {
        PlayerDTO playerDTO = playerService.getPlayerById(id);

        if (playerDTO != null){
            return playerService.changePlayerPseudo(id, playerData);
        } else {
            throw  new RessourceNotFoundException();
        }
    }
}
