package com.mygame.strategy;

public interface AttackStrategy {
    int execute(int attackPoints);
    double getSuccessProbability();
}
