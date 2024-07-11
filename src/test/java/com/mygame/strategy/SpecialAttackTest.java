package com.mygame.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpecialAttackTest {
    @Test
    public void testExecute() {
        SpecialAttack specialAttack = new SpecialAttack();
        assertEquals(20, specialAttack.execute(10));
    }
}
