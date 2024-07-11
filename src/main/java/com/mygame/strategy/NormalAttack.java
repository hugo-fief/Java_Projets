package com.mygame.strategy;

public class NormalAttack implements AttackStrategy {
    @Override
    public int execute(int attackPoints) {
        return attackPoints;
    }
}
