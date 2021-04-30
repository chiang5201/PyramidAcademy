package com.company;
import java.util.Scanner;  // Import the Scanner class
import java.util.*;
public class Main {
    public static void drawMan(int count, String [][] man )
    {	switch (count)
        {   case 0:
            break;
            case 1:
                man[1][1]="O";
                break;
            case 2:
                man[2][1]="|";
                break;
            case 3:
                man[2][0]="/";
                break;
            case 4:
                man[2][2]="\\";
                break;
            case 5:
                man[3][0]="/";
                break;
            case 6:
                man[3][2]="\\";
                break;
        }
        for(int y=0;y<man.length;y++)
        {   for(int x=0;x< man[0].length;x++)
                System.out.print(man[y][x]);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
	// write your code here
        boolean playing=true;
        int wrongCount,playCount=0,correctCount;
        String[][] word=new String[][] {{"c","a","t"},
                                        {"o","l","d"},
                                        {"t","r","y"},
                                        {"n","e","w"},
                                        {"t","e","a"}
                                        } ;
        String[][] startMan= new String[][]{    {" ","+","=","+" },
                                                {" "," "," ","|" },
                                                {" "," "," ","|" },
                                                {" "," "," ","|" },
                                                {"=","=","=","=" }
                                            } ;
        System.out.println("H A N G M A N");
        while (playing)
        {  //---------initialize----------------------------
            boolean print=true;
            String missing="";
            String[][] man=startMan;
            HashSet<String> litters = new HashSet<>();
            String[] correctAt=new String[]  {"_","_","_"};
            correctCount=0;
            drawMan(correctCount, man);
            System.out.println("Missed letters:");
            System.out.println("___");
            //------------------star game-----------------------------
            for(wrongCount=0;wrongCount<6;wrongCount++)
            {   System.out.println("Guess a letter.");
                String guess=new Scanner(System.in).nextLine();
                for(int i=0;i<word[playCount].length ;i++)          //check input
                {   if (litters.contains(guess))                    //retype input
                    {   print = false;
                        wrongCount--;
                        break;
                    }
                    else if (guess.equals(word[playCount][i]))      // new input
                    {   correctAt[i] = guess;
                        correctCount++;
                        wrongCount--;
                        missing+=guess;
                        break;
                    }
                }
                //--------------------output game-------------------
                if(correctCount==3)
                    break;
                else if(!print)
                    System.out.println("You have already guessed that letter. Choose again.");
                else
                {   drawMan(wrongCount+1, man);
                    System.out.println("Miss letter: "+missing);
                    for(int j=0; j<correctAt.length;j++)
                        System.out.print(correctAt[j]);
                    System.out.println("");
                }print=true;
                 litters.add(guess);
            }
            /*-------------------------End Game------------------------------------------*/
            String ans=word[playCount][0]+word[playCount][1]+word[playCount][2];
            if(correctCount!=3)
                System.out.println("nice try! the word is "+ans);
            else
                System.out.println("Yes! The secret word is \""+ans+"\"! You have won!");
            System.out.println("Would you like to play again? (yes or no)");
            String readIn = new Scanner(System.in).nextLine(); // Read user input
            if(readIn.equals("no")||playCount==word.length-1)
                playing=false;
            playCount++;
        }


    }
}
