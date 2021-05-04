package com.company;
import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Battleship Multiplayer");
        System.out.print("Enter Player 1 name:");
        String player1=new Scanner(System.in).nextLine();
        System.out.print("Enter Player 2 name:");
        String player2=new Scanner(System.in).nextLine();
        MainBattleship p1=new Ship(player1);
        p1.getShipMap();
        while(!p1.setShipMap()) {}

        MainBattleship p2=new Ship(player2);
        System.out.println("---------------------------");
        p2.getShipMap();
        while(!p2.setShipMap()) {}

        while(1==1)
        {   System.out.println("-----------------------------");
            p1.getBattleMap();
            while (!p1.attack()) { }
            if(p1.Win()) {
                System.out.println(player1 + " win the game");
                return;
            }
            System.out.println("-----------------------------");
            p2.getBattleMap();
            while (!p2.attack()) { }
            if(p2.Win()){
                System.out.println(player2+" win the game");
                return;
            }
        }
    }
}
