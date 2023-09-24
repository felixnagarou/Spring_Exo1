package com.example.spring_exo1.controllers;

import com.example.spring_exo1.exceptions.RessourceNotFoundException;
import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;


   @GetMapping("/{playerId}")
   public String getPlayerDetails(@PathVariable("playerId") UUID uuid, Model model){
       PlayerDTO found = playerService.getPlayerById(uuid);
           model.addAttribute("player", found);
           model.addAttribute("details", "details");
           return "/players/form";
   }

    @GetMapping
    public String playerList(Model model, @RequestParam(value = "id", defaultValue = "") String filterByPseudo){
        List<PlayerDTO> players = playerService.getPlayers();

        if (!filterByPseudo.isEmpty() && !filterByPseudo.isBlank()){
            players = players.stream().filter(p -> p.getPseudo().startsWith(filterByPseudo)).toList();
        }
        model.addAttribute("players", players);
        return "players/list";
    }


    @GetMapping("/addPlayer")
    public String playerFormRedirect(Model model){
        model.addAttribute("player", PlayerDTO.builder().build());
        model.addAttribute("mode", "add");
        return "players/form";
    }

    @PostMapping("/add")
    public String addPlayerHandler(PlayerDTO newPlayer){
       playerService.addPlayer(newPlayer);

       return "redirect:/players";
    }

    @PatchMapping("/edit/{playerId}")
    public String editPLayerGivenId(@PathVariable("playerId") UUID id, PlayerDTO playerData){
       playerService.changePlayerPseudo(id, playerData) ;
       return "redirect:/players";
    }

    @DeleteMapping ("/delete/{playerId}")
    public String deletePlayerById(@PathVariable("playerId") UUID id) {
       playerService.deletePlayerById(id);
       return "redirect:/players";
    }


}
