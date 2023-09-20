package com.example.spring_exo1.controllers;

import com.example.spring_exo1.models.PlayerDTO;
import com.example.spring_exo1.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;


   //@GetMapping("/{playerId}")
   //public String getPlayerDetails(@PathVariable("playerId") UUID uuid, Model model){
   //    Optional<PlayerDTO> found = playerService.getPlayerById(uuid);

   //    if (found.isPresent()){
   //        model.addAttribute("player", found.get());
   //        model.addAttribute("details", "details");

   //    }
   //}

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


}
