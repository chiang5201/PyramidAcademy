package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;  // Import the Scanner class
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static String error=" ";
    static String output="___";
    public  static void history(String name, int guessCount)throws IOException
    {   output="___";
        error=" ";
        try{
            File out = new File("output.txt");
            out.createNewFile();
            String readIN=Files.readString(Paths.get("output.txt"));
            String [] temp=readIN.split(" ");
            List<String> hist=Arrays.asList(temp).stream().filter(x->x.length()==1).sorted().collect(Collectors.toList());
            if(Integer.parseInt(hist.get(0))>guessCount)
                System.out.println("congratulations "+name+"! you have the high score of game");
            Files.writeString(Path.of("output.txt"), readIN+" "+name+" "+guessCount );
        }
        catch (Exception e)
        {   System.out.println("!!!!!! here is history function !!!!!!");
            e.printStackTrace();
        }
    }
    public  static int guess(String readIn, String ans)
    {
        if(readIn.length()>1)
        {   System.out.println(" guessed a letter. Choose again.");
            return  0;
        }
        else if(ans.indexOf(readIn)==-1 && error.indexOf(readIn)==-1)
        {   error=error+readIn;
            return -1;
        }
        else if(output.indexOf(readIn)!=-1)
        {   System.out.println("You have already guessed that letter. Choose again.");
            return 0;
        }
        else if (ans.indexOf(readIn)==0)
            output=readIn+output.charAt(1)+output.charAt(2);
        else if (ans.indexOf(readIn)==1)
            output=output.charAt(0)+readIn+output.charAt(2);
        else if (ans.indexOf(readIn)==2)
            output=output.charAt(0)+output.charAt(1)+readIn;

        return 1;
    }
    public static void drawMan(int time) throws IOException
    {
        int  count=5*time;
        try{
            List<String> man=Files.readAllLines(Paths.get( "man.txt" ));
            System.out.println(man.get(count+0));
            System.out.println(man.get(count+1));
            System.out.println(man.get(count+2));
            System.out.println(man.get(count+3));
            System.out.println(man.get(count+4));
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("!!!!!error on the draw man function!!!!!!!");
        }
    }
    public static void main(String[] args) throws IOException {
	// write your code here
        int guessCount=0,time=0;
        String [] ans= new String[]{"cat","new","old","tea","dog","pig","bus","sum","who","ice","hot","you","she"};
        System.out.println("H A N G M A N ");
        System.out.println("what is your name??");
        String name= new Scanner(System.in).nextLine(); // Read user input
        while(1==1)
        {
            String readIn="";
            drawMan(guessCount);
            System.out.println("Missed letters:"+error);
            System.out.println(output);
            System.out.println("Guess a letter.");
            readIn = new Scanner(System.in).nextLine(); // Read user input
            try
            {   if (guess(readIn, ans[time])==-1) {guessCount++;}
                if(guessCount==6)
                {   System.out.println("NO! "+name+" The secret word is "+ans[time]+"! You have lost! your score is "+(guessCount+1));
                    history(name,guessCount+1);
                    guessCount=-1;
                }
                else if(output.indexOf("_")==-1)
                {   System.out.println("Yes! "+name+" The secret word is "+ans[time]+"! You have won! your score is "+(guessCount+1));
                    history(name,guessCount+1);
                    guessCount=-1;
                }
            }catch (Exception e){
                System.out.println("!!!!!!out of index!!!!!!!");
                e.printStackTrace();
            }
            if(guessCount==-1) //reset
            {   guessCount=0;
                time++;
                System.out.println("Would you like to play again? (yes or no)");
                readIn = new Scanner(System.in).nextLine(); // Read user input
                if(readIn.equals("no")) break;
                System.out.println("what is your name??");
                name= new Scanner(System.in).nextLine(); // Read user input
            }
        }
    }
}
