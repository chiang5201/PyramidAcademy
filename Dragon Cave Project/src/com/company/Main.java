package com.company;
import java.util.Scanner;
import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)\n");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int input = myObj.nextInt();  // Read user input
        System.out.println("");
        try
        {   if(input==1)
            {  System.out.println("You approach the cave...");
               System.out.println("It is dark and spooky...");
               System.out.println("A large dragon jumps out in front of you! He opens his jaws and... ");
               System.out.println("Gobbles you down in one bite!");
               System.out.println("You die!!");
            }
            else if(input==2)
            {   System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He ask you why are you here?");
                System.out.println("you say you are look for treasure!!");
                System.out.println("The dragon getting you all him treasure");
            }else
            System.out.println("~~ERROR~~");
        }
        catch (Exception e)
        { return;
        }
    }
}
