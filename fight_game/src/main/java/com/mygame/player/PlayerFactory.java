package com.mygame.player;

import com.mygame.strategy.NormalAttack;
import com.mygame.strategy.SpecialAttack;

public class PlayerFactory {
    public static Player createPlayer(String type, String name) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new Player(name, 100, 10, new NormalAttack());
            case "mage":
                return new Player(name, 80, 15, new SpecialAttack());
            default:
                throw new IllegalArgumentException("Unknown player type: " + type);
        }
    }
}
