package com.mygame.strategy;

import java.util.Random;

public class NormalAttack implements AttackStrategy {
    private static final double SUCCESS_PROBABILITY = 0.75;
    private Random random = new Random();

    @Override
    public int execute(int attackPoints) {
        if (random.nextDouble() <= SUCCESS_PROBABILITY) {
            return attackPoints;
        } else {
            return 0;
        }
    }

    @Override
    public double getSuccessProbability() {
        return SUCCESS_PROBABILITY;
    }
}
