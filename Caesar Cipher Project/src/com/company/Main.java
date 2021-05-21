package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    final static char[] lower=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    final static char[] upper=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    static char shift(char litter, int num)
    {
        for(int i=0; i< lower.length; i++)
        {   if(lower[i]==litter)
                return lower[(i+num)%26];
            else if(upper[i]==litter)
                return upper[(i+num)%26];
        }
        return litter;
    }

    public static void encrypt()
    {
        System.out.println("Enter your message:");
        String readIn=new Scanner(System.in).nextLine();
        System.out.println("Enter the key number (1-52)");
        int input=new Scanner(System.in).nextInt();
        String save="";
        for(int i=0; i<readIn.length(); i++)
        {   save=save+shift(readIn.charAt(i),input);
        }
        System.out.println(save);
        try{
                File out = new File("output.txt");
                out.createNewFile();
                Files.writeString(Path.of("output.txt"),save);
            }
        catch (Exception e){e.printStackTrace();}
    }

    public static void decrypt() throws IOException
    {   System.out.println("Enter your message:");
        String output="";
        try{
            String readIn=Files.readString(Paths.get( "output.txt" ));
            System.out.println(readIn);
            System.out.println("Enter the key number (1-52)");
            int input= new Scanner(System.in).nextInt();
            for(int i=0; i<readIn.length(); i++)
                output= output+ shift(readIn.charAt(i),0-input);
            System.out.println("Your translated text is:\n"+output);
            }
        catch   (Exception e){e.printStackTrace(); return;}
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        while (1==1) {
            System.out.println("Do you wish to encrypt or decrypt a message?");
            String readIn = new Scanner(System.in).nextLine();
            if (readIn.equals("decrypt"))
                decrypt();
            else if(readIn.equals("encrypt"))
                encrypt();
        }
    }
}
