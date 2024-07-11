package com.mygame.strategy;

import java.util.Random;

public class SpecialAttack implements AttackStrategy {
    private static final double SUCCESS_PROBABILITY = 0.50;
    private Random random = new Random();

    @Override
    public int execute(int attackPoints) {
        if (random.nextDouble() <= SUCCESS_PROBABILITY) {
            return attackPoints * 2;
        } else {
            return 0;
        }
    }

    @Override
    public double getSuccessProbability() {
        return SUCCESS_PROBABILITY;
    }
}
