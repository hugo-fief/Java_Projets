package com.mygame.battle;

import com.mygame.player.Player;
import com.mygame.strategy.NormalAttack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {
    @Test
    public void testBattle() {
        Player player1 = new Player("Player 1", 100, 10, new NormalAttack());
        Player player2 = new Player("Player 2", 100, 10, new NormalAttack());
        Battle battle = new Battle(player1, player2);
        
        battle.start();
        
        assertTrue(player1.isAlive() || player2.isAlive());
    }
}
