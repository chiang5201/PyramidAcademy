package company;

import java.util.HashSet;

public class Game {
    private  char play, computer;
    private  char[][]map;
    private  int count;
    private HashSet<Integer> hist;
    Game(char user, char ai)
    {   this.play= user;
        this.computer=ai;
        this.map= new char[][]{ {' ',' ',' '},
                                {' ',' ',' '},
                                {' ',' ',' '},
                                };
        this.hist=new HashSet<>();
        this.count=0;
    }
    public Boolean userMove(int step)
    {
        if(hist.contains(step)|| step>9 || step<-1)
        {
            System.out.println("~~ERROR~~ Choose again.");
            return false;
        }
        hist.add(step);
        switch (step)
        {   case 1:
            map[0][0]=play;
            break;
            case 2:
                map[0][1]=play;
                break;
            case 3:
                map[0][2]=play;
                break;
            case 4:
                map[1][0]=play;
                break;
            case 5:
                map[1][1]=play;
                break;
            case 6:
                map[1][2]=play;
                break;
            case 7:
                map[2][0]=play;
                break;
            case 8:
                map[2][1]=play;
                break;
            case 9:
                map[2][2]=play;
                break;
        }
        return  true;
    }

    public Boolean aiMove()
    {
        if(count==5)
        {   System.out.println("This is a tie game");
            return false;
        }count++;
        int step=(int)(Math.random()*10)+1;
        while (hist.contains(step))
        {   step++;
            if(step>9) step=1;
        }
        hist.add(step);
        switch (step)
        {   case 1:
            map[0][0]=computer;
            break;
            case 2:
                map[0][1]=computer;
                break;
            case 3:
                map[0][2]=computer;
                break;
            case 4:
                map[1][0]=computer;
                break;
            case 5:
                map[1][1]=computer;
                break;
            case 6:
                map[1][2]=computer;
                break;
            case 7:
                map[2][0]=computer;
                break;
            case 8:
                map[2][1]=computer;
                break;
            case 9:
                map[2][2]=computer;
                break;
        }
        return  true;
    }


    public Boolean userWins()
    {
        if(map[0][0]==play && map[0][1]==play && map[0][2]==play) //row0
            return true;
        else if(map[1][0]==play && map[1][1]==play && map[1][2]==play) //row1
            return true;
        else if(map[2][0]==play && map[2][1]==play && map[2][2]==play) //row2
            return true;
        else if(map[0][0]==play && map[1][0]==play && map[2][0]==play) //col0
            return true;
        else if(map[0][1]==play && map[1][1]==play && map[2][1]==play) //col1
            return true;
        else if(map[0][2]==play && map[1][2]==play && map[2][2]==play) //col2
            return true;
        else if(map[0][0]==play && map[1][1]==play && map[2][2]==play) //Diag
            return true;
        else if(map[0][2]==play && map[1][1]==play && map[2][0]==play) //backDiag
            return true;
        return false;
    }

    public Boolean AIWins()
    {
        if(map[0][0]==computer && map[0][1]==computer && map[0][2]==computer) //row0
            return true;
        else if(map[1][0]==computer && map[1][1]==computer && map[1][2]==computer) //row1
            return true;
        else if(map[2][0]==computer && map[2][1]==computer && map[2][2]==computer) //row2
            return true;
        else if(map[0][0]==computer && map[1][0]==computer && map[2][0]==computer) //col0
            return true;
        else if(map[0][1]==computer && map[1][1]==computer && map[2][1]==computer) //col1
            return true;
        else if(map[0][2]==computer && map[1][2]==computer && map[2][2]==computer) //col2
            return true;
        else if(map[0][0]==computer && map[1][1]==computer && map[2][2]==computer) //Diag
            return true;
        else if(map[0][2]==computer && map[1][1]==computer && map[2][0]==computer) //backDiag
            return true;
        return false;
    }

    public void Drawing()
    {
        System.out.println(map[0][0]+"|"+map[0][1]+"|"+map[0][2]);
        System.out.println("------");
        System.out.println(map[1][0]+"|"+map[1][1]+"|"+map[1][2]);
        System.out.println("------");
        System.out.println(map[2][0]+"|"+map[2][1]+"|"+map[2][2]);
    }

}
