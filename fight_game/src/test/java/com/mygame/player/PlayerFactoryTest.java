package com.mygame.player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerFactoryTest {
    @Test
    public void testCreatePlayer() {
        Player warrior = PlayerFactory.createPlayer("warrior", "Warrior");
        assertNotNull(warrior);
        assertEquals("Warrior", warrior.getName());

        Player mage = PlayerFactory.createPlayer("mage", "Mage");
        assertNotNull(mage);
        assertEquals("Mage", mage.getName());
    }
}
