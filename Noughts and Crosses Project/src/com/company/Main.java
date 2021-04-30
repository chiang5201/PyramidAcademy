package com.company;
import java.util.HashSet;
import java.util.Scanner;  // Import the Scanner class
import java.lang.Math;

public class Main {
    public static Boolean Wins(char[][]map,char who)
    {
        if(map[0][0]==who && map[0][1]==who && map[0][2]==who) //row0
            return true;
        else if(map[1][0]==who && map[1][1]==who && map[1][2]==who) //row1
            return true;
        else if(map[2][0]==who && map[2][1]==who && map[2][2]==who) //row2
            return true;
        else if(map[0][0]==who && map[1][0]==who && map[2][0]==who) //col0
            return true;
        else if(map[0][1]==who && map[1][1]==who && map[2][1]==who) //col1
            return true;
        else if(map[0][2]==who && map[1][2]==who && map[2][2]==who) //col2
            return true;
        else if(map[0][0]==who && map[1][1]==who && map[2][2]==who) //Diag
            return true;
        else if(map[0][2]==who && map[1][1]==who && map[2][0]==who) //backDiag
            return true;
        return false;
    }
    public static Boolean move(char[][] map,int At, char move,HashSet<Integer> hist, int AI)
    {
        if(At>9) At=9;
        else if(At<1) At=1;
        if(AI==1)
            while (hist.contains(At))
            {   At++;
                if(At>9) At=1;
            }
        else if(hist.contains(At))
        {
            System.out.println("~~ERROR~~ Choose again.");
            return false;
        }
        hist.add(At);
        switch (At)
        {   case 1:
                map[0][0]=move;
                break;
            case 2:
                map[0][1]=move;
                break;
            case 3:
                map[0][2]=move;
                break;
            case 4:
                map[1][0]=move;
                break;
            case 5:
                map[1][1]=move;
                break;
            case 6:
                map[1][2]=move;
                break;
            case 7:
                map[2][0]=move;
                break;
            case 8:
                map[2][1]=move;
                break;
            case 9:
                map[2][2]=move;
                break;
        }
        return true;
    }
    public static void Drawing(char[][] map)
    {
        System.out.println(map[0][0]+"|"+map[0][1]+"|"+map[0][2]);
        System.out.println("------");
        System.out.println(map[1][0]+"|"+map[1][1]+"|"+map[1][2]);
        System.out.println("------");
        System.out.println(map[2][0]+"|"+map[2][1]+"|"+map[2][2]);
    }

    public static void main(String[] args) {
	// write your code here
        String readIn ="";
               char[][] intmap= new char[][]{  {' ',' ',' '},
                                                {' ',' ',' '},
                                                {' ',' ',' '},
                                            };
        System.out.println("Welcome to Tic-Tac-Toe!");
        while(1==1)
        {//-------------------int----------------
            char user =' ', ai=' ';
            for(int y=0; y<map.length;y++)
                for(int x=0;x<map[0].length;x++)
                    map[y][x]= ' ';
			int step=0;
            HashSet <Integer> hist=new HashSet<>();
            System.out.println("Do you want to be X or O?");
            readIn = new Scanner(System.in).nextLine(); // Read user input
            if(readIn.equals("X")||readIn.equals("x"))
            {   user='X';
                ai='O';
            } else
            {   user='O';
                ai='X';
            }
            System.out.println("The computer will go first.");
            //------------------playing---------------------
            while (1==1)
            {
                int computer=(int)(Math.random() * 10)+1;
                move(map,computer,ai,hist,1);
                step++;
                Drawing(map);
                if (step==5)
                {   System.out.println("This is a tie game");
                    break;
                }
                else if (Wins(map,ai))
                {   System.out.println("The computer has beaten you! You lose.");
                    break;
                }
                while (1==1)
                {   System.out.println("What is your next move? (1-9)");
                    int userIN = new Scanner(System.in).nextInt(); // Read user input
                    if( move(map, userIN, user, hist, 0))
                        break;
                }
                if (Wins(map, user))
                {   Drawing(map);
                    System.out.println("You has beaten the computer! You Win.");
                    break;
                }
            }
            //-----------------end game-------------------------
            System.out.println("Do you want to play again? (yes or no)");
            readIn = new Scanner(System.in).nextLine(); // Read user input
            if(readIn.equals("no"))
                break;;
        }
    }
}
