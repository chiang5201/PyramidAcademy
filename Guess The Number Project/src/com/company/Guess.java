package company;

public class Guess {
    private  int count, number;
    private  String name;
    Guess(String name, int input)
    {   this.name= name;
        this.number= input;
        this.count=0;
    }
    public boolean play( int input)
    {
        if(count==6)
            return false;
        else if(input==number)
            return  false;
        else if(input<number)
            System.out.println("Your guess is too low.");
        else
            System.out.println("Your guess is too high.");
        count++;
        return  true;
    }
    public void endGame (int input)
    {
        if(count==6)
            System.out.println("nice try "+name+"! My number is "+number);
        else
            System.out.println("Good job "+name+"! You guessed my number in " + count + " guesses!");
        count=0;
        number= input;
    }

}
