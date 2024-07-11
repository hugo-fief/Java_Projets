package com.mygame.battle;

import com.mygame.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        logger.info("Battle started between {} and {}", player1.getName(), player2.getName());
        while (player1.isAlive() && player2.isAlive()) {
            player1.attack(player2);
            rounds++;
            if (player2.isAlive()) {
                player2.attack(player1);
                rounds++;
            }
        }

        if (player1.isAlive()) {
            logger.info("{} wins after {} rounds!", player1.getName(), rounds);
        } else {
            logger.info("{} wins after {} rounds!", player2.getName(), rounds);
        }
    }
}
