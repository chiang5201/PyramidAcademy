package com.company;
import java.util.Scanner;  // Import the Scanner class
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean thinking=true;
        int guessCount;
        int num;
        String userName;
        System.out.println("Hello! What is your name?");
        try {
             userName = new Scanner(System.in).nextLine();  // Read user input
        } catch (Exception e )
        {   System.out.println("!!error!!");
            return; }
        while (thinking)
        {
            num=(int)(Math.random() * 10) + (int) (Math.random() * 10) +1;
            System.out.println("Well, " + userName + " I am thinking of a number between 1 and 20.");
            for(guessCount=0;guessCount<6;guessCount++)
            {
                System.out.println("Take a guess.");
                int inputNum;
                try{ inputNum=new Scanner(System.in).nextInt();}
                catch (Exception e )
                {   System.out.println("!!error!!");
                    return; }
                if(inputNum==num)
                    break;
                else if(inputNum<num)
                    System.out.println("Your guess is too low.");
                else
                    System.out.println("Your guess is too high.");
            }
            if(guessCount==6)
                System.out.println("nice try "+userName+"! My number is "+num);
            else
                System.out.println("Good job "+userName+"! You guessed my number in " + guessCount + " guesses!");
            System.out.println("Would you like to play again? (y or n)");
            String playing="";
            try { playing = new Scanner(System.in).nextLine(); // Read user input
            }  catch (Exception e){   System.out.println("!!error!!");
            return; }
            if(playing.equals("n"))
                thinking=false;
        }


    }
}
