package com.company;
import com.company.Map;

import java.util.Scanner;


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
            System.out.println("what is your next move Human");
            while (!world.HumanMove(new Scanner(System.in).nextLine()))
                System.out.println("what is your next move Human!!!");
            world.GoblinMove();
            if(!world.collide()) break;
            world.draw();
        }
    }
}
