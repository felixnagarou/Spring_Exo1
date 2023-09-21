package com.example.spring_exo1.mappers;

import com.example.spring_exo1.entities.Player;
import com.example.spring_exo1.models.PlayerDTO;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper
public interface PlayerMapper {


    PlayerDTO playerToPlayerDTO(Player player);

    Player playerDTOToPlayer(PlayerDTO dto);

    public static Integer convertDateToYears(LocalDate date){
        LocalDate now = LocalDate.now();
        Integer numberOfYears = now.getYear() - date.getYear();
        return numberOfYears;
    }
}
