package com.example.spring_exo1.mappers;

import com.example.spring_exo1.entities.Player;
import com.example.spring_exo1.models.PlayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper
public interface PlayerMapper {

    @Mapping(source ="firstLogDate", target = "years", qualifiedByName = "convertDateToYears")
    PlayerDTO playerToPlayerDTO(Player player);

    Player playerDTOToPlayer(PlayerDTO dto);


    @Named("convertDateToYears")
    public static Integer convertDateToYears(LocalDate date){
        LocalDate now = LocalDate.now();
        return now.getYear() - date.getYear();
    }


}
