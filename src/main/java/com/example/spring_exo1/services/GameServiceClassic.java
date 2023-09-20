package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Game;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"classic", "default"})
public class GameServiceClassic implements GameService {

    //private final Game game = null;

    public GameServiceClassic() {
        Game game = new Game();
    }
}
