package com.mygame.strategy;

public class SpecialAttack implements AttackStrategy {
    @Override
    public int execute(int attackPoints) {
        return attackPoints * 2;
    }
}
