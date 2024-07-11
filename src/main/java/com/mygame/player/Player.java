package com.mygame.player;

import com.mygame.strategy.AttackStrategy;

public class Player {
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
        System.out.println(name + " attacks " + opponent.getName() + " for " + damage + " damage.");
    }

    public boolean isAlive() {
        return health > 0;
    }
}
