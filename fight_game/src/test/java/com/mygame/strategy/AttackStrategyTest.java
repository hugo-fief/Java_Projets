package com.mygame.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttackStrategyTest {
    @Test
    public void testNormalAttack() {
        AttackStrategy normalAttack = new NormalAttack();
        assertEquals(10, normalAttack.execute(10));
    }

    @Test
    public void testSpecialAttack() {
        AttackStrategy specialAttack = new SpecialAttack();
        assertEquals(20, specialAttack.execute(10));
    }
}
