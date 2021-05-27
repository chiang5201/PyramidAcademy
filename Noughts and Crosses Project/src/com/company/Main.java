package company;
import java.util.Scanner;  // Import the Scanner class


public class Main {

    public static void main(String[] args) {
	// write your code here
        String readIn ="";

        System.out.println("Welcome to Tic-Tac-Toe!");
        Game game;
        while(1==1)
        {
            System.out.println("Do you want to be X or O?");
            try { readIn = new Scanner(System.in).nextLine(); }// Read user input
            catch (Exception e) {
                System.out.println("cant read you input");
                return; }
            if (readIn.equals("X") || readIn.equals("x"))
                game= new Game('X','0');
             else
                game= new Game('O','X');
            System.out.println("The computer will go first.");
            while (1==1)
            {   if(!game.aiMove())
                    break;
                game.Drawing();
                if(game.AIWins())
                {   System.out.println("The computer has beaten you! You lose.");
                    break;
                }
                System.out.println("What is your next move? (1-9)");
                while (!game.userMove(new Scanner(System.in).nextInt()))
                    System.out.println("What is your next move? (1-9)");
                if (game.userWins())
                {   game.Drawing();
                    System.out.println("You has beaten the computer! You Win.");
                   break;
                }
            }
            System.out.println("Do you want to play again? (yes or no)");
            readIn = new Scanner(System.in).nextLine(); // Read user input
            if(readIn.equals("no"))
               break;;
        }

    }
}
