package com.mygame.player;

import com.mygame.strategy.AttackStrategy;
import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.fusesource.jansi.Ansi.ansi;

public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private String name;
    private int health;
    private int attackPoints;
    private AttackStrategy attackStrategy;

    public Player(String name, int health, int attackPoints, AttackStrategy attackStrategy) {
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.attackStrategy = attackStrategy;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void attack(Player opponent) {
        int damage = attackStrategy.execute(attackPoints);
        if (damage > 0) {
            opponent.takeDamage(damage);
            logger.info(ansi().fg(Ansi.Color.GREEN).a("{} attacks {} for {} damage. {}'s health is now {}.").reset().toString(),
                    name, opponent.getName(), damage, opponent.getName(), opponent.getHealth());
        } else {
            logger.info(ansi().fg(Ansi.Color.RED).a("{} attacks {} but misses.").reset().toString(),
                    name, opponent.getName());
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
