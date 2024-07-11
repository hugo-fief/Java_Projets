package com.mygame.player;

import com.mygame.strategy.NormalAttack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerCreation() {
        Player player = new Player("Test Player", 100, 10, new NormalAttack());
        assertEquals("Test Player", player.getName());
        assertEquals(100, player.getHealth());
    }

    @Test
    public void testPlayerAttack() {
        Player player1 = new Player("Player 1", 100, 10, new NormalAttack());
        Player player2 = new Player("Player 2", 100, 10, new NormalAttack());
        
        player1.attack(player2);
        assertTrue(player2.getHealth() < 100);
    }
}
