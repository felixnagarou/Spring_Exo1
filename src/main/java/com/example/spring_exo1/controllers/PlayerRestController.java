package com.example.spring_exo1.controllers;

import com.example.spring_exo1.exceptions.RessourceNotFoundException;
import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.services.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/players")
@RequiredArgsConstructor
@Slf4j
public class PlayerRestController {
    private final PlayerService playerService;


    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<String> deletePlayerById(@PathVariable("playerId") UUID id) {
        Optional<PlayerDTO> foundPlayer = playerService.getPlayerById(id);

        if (foundPlayer.isPresent()) {
            if (playerService.deletePlayerById(id)) {
                return new ResponseEntity<String>("Player was deleted at id : " + id, HttpStatus.OK);
            }
            return new ResponseEntity<String>("Error while trying to delete player", HttpStatus.NOT_MODIFIED);
        } else {
            throw new RessourceNotFoundException();
        }
    }
}
