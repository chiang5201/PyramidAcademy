package com.company;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    @Test
    void Human()
    {   Humans one=new Humans(1,1,10 );
        assertEquals(  "this humans at x=1 y=1 Health=10 gen=0", one.toString());
        assertEquals(false, one.getAttack(1));
        assertEquals(true, one.getAttack(22));
        assertEquals(1, one.getX());
        assertEquals(1, one.getY());
        assertEquals(0, one.getGen());
        one.setGen(2);
        one.setX(2);
        one.setY(2);
        assertEquals(2, one.getX());
        assertEquals(2, one.getY());
        assertEquals(2, one.getGen());
    }

    @Test
    void Goblins()
    { Goblins one= new Goblins(1,1,10);
        assertEquals(  "this Goblins at x=1 y=1 Health=10", one.toString());
        assertEquals(false, one.getAttack(1));
        assertEquals(true, one.getAttack(22));
        assertEquals(1, one.getX());
        assertEquals(1, one.getY());
        one.setX(2);
        one.setY(2);
        assertEquals(2, one.getX());
        assertEquals(2, one.getY());
    }

    @Test
    void Map()
    {   Map one=new Map();
        assertEquals(true,  one.draw());
        assertEquals(true, one.collide());
        assertEquals(false, one.HumanMove("a"));
        assertEquals(false, one.HumanMove("w"));
        assertEquals(true,  one.HumanMove("s"));
        assertEquals(true,  one.HumanMove("s"));
        assertEquals(true,  one.HumanMove("d"));
        assertEquals(true,  one.HumanMove("d"));
        one.GoblinMove();
        assertEquals(true, one.collide());
        assertEquals(true,  one.HumanMove("s"));
        assertEquals(false,  one.HumanMove("s"));
        assertEquals(true,  one.HumanMove("d"));
        assertEquals(false,  one.HumanMove("d"));
        one.GoblinMove();
        one.GoblinMove();
        one.GoblinMove();
        one.GoblinMove();
        one.GoblinMove();
        assertEquals(false, one.collide());
    }

}