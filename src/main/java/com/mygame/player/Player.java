package com.mygame.player;

import com.mygame.strategy.AttackStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        opponent.takeDamage(damage);
        logger.info("{} attacks {} for {} damage. {}'s health is now {}.", name, opponent.getName(), damage, opponent.getName(), opponent.getHealth());
    }

    public boolean isAlive() {
        return health > 0;
    }
}
