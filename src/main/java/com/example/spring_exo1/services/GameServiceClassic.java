package com.example.spring_exo1.services;

import com.example.spring_exo1.models.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"classic", "default"})
public class GameServiceClassic implements GameService {

    private final Game game = new Game();

    public GameServiceClassic() {
    }

    @Override
    public int updateTurnCountUntilSentenceFinished() {
        return game.getTurnCount()+1;
    }


    @Override
    public Game getGame() {
        return game;
    }
}
