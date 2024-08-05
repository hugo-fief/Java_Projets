package com.mygame.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NormalAttackTest {
    @Test
    public void testExecute() {
        NormalAttack normalAttack = new NormalAttack();
        assertEquals(10, normalAttack.execute(10));
    }
}
