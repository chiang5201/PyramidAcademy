package com.company;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    MainBattleship game;
    @BeforeEach
    void setUP ()
    {
        game =new Ship("me");
    }

    @Test
    void attack() {
        assertEquals(true,game.attack());
    }

    @Test
    void win() {
        assertEquals(false, game.Win() );
    }

    @Test
    void setShipMap() {
        assertEquals(true, game.setShipMap());
    }

    @Test
    void getBattleMap() {
        game.getBattleMap();
    }

    @Test
    void getShipMap() {
        game.getShipMap();
    }
}