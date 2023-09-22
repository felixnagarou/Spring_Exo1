package com.example.spring_exo1.repositories;

import com.example.spring_exo1.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PLayerRepository extends JpaRepository<Player, UUID> {
    List<Player> findAllByPseudoStartingWith (String value);

    List<Player> findAllByOrderByFirstLogDateAsc (String value);
}
