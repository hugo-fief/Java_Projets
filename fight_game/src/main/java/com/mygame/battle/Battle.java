package com.mygame.battle;

import com.mygame.player.Player;
import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.fusesource.jansi.Ansi.ansi;

public class Battle {
    private static final Logger logger = LoggerFactory.getLogger(Battle.class);
    private Player player1;
    private Player player2;
    private int rounds;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = 0;
    }

    public void start() {
        logger.info(ansi().fg(Ansi.Color.CYAN).a("Battle started between {} and {}").reset().toString(),
                player1.getName(), player2.getName());
        while (player1.isAlive() && player2.isAlive()) {
            player1.attack(player2);
            rounds++;
            if (player2.isAlive()) {
                player2.attack(player1);
                rounds++;
            }
        }

        if (player1.isAlive()) {
            logger.info(ansi().fg(Ansi.Color.GREEN).a("{} wins after {} rounds!").reset().toString(),
                    player1.getName(), rounds);
        } else {
            logger.info(ansi().fg(Ansi.Color.GREEN).a("{} wins after {} rounds!").reset().toString(),
                    player2.getName(), rounds);
        }
    }
}
