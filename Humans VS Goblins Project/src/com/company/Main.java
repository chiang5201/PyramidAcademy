package com.company;
import com.company.Map;


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome the game of Goblins VS Humans");
        System.out.println("note G is for Goblins");
        System.out.println("note H is for Humans");
        Map world=new Map();
        world.draw();
        for(; ; )
        {   System.out.println("pleases use w for up");
            System.out.println("pleases use s for down");
            System.out.println("pleases use a for right");
            System.out.println("pleases use d for left");
            while (!world.HumanMove()){}
            world.GoblinMove();
            if(!world.collide()) break;
            world.draw();
        }
    }
}
