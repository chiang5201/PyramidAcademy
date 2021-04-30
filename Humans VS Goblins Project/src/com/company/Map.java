package com.company;
import java.util.Scanner;  // Import the Scanner class

public class Map {
    private Humans player1;
    private Goblins player2;
    private int genX,genY;

    char[][]map=new char[4][4];

    public Map()
    {   for(int i=0; i<map.length;i++)
            for(int j=0;j<map[0].length;j++)
                map[j][i]=' ';
            player1 =new Humans(0,0,250);
            player2 =new Goblins(3,3,100);
    }

    private void resetMap()
    {   for(int i=0; i<map.length;i++)
            for(int j=0;j<map[0].length;j++)
                map[j][i]=' ';
    }


    public void draw()
    {
        resetMap();
        map[player2.getY()][player2.getX()]='G';  //ai
        map[player1.getY()][player1.getX()]='H'; //player
        System.out.println(map[0][0]+"|"+map[0][1]+"|"+map[0][2]+"|"+map[0][3]);
        System.out.println("-+-+-+-");
        System.out.println(map[1][0]+"|"+map[1][1]+"|"+map[1][2]+"|"+map[1][3]);
        System.out.println("-+-+-+-");
        System.out.println(map[2][0]+"|"+map[2][1]+"|"+map[2][2]+"|"+map[2][3]);
        System.out.println("-+-+-+-");
        System.out.println(map[3][0]+"|"+map[3][1]+"|"+map[3][2]+"|"+map[3][3]);
    }
    public boolean HumanMove()
    {   System.out.println("what is your next move Human");
        String readIn = new Scanner(System.in).nextLine(); // Read user input
        if(      (readIn.equals("W")||readIn.equals("w")) && player1.getY()-1>-1)
            player1.setY(player1.getY()-1);
        else if( (readIn.equals("S")||readIn.equals("s")) && player1.getY()+1<4)
            player1.setY(player1.getY()+1);
        else if( (readIn.equals("A")||readIn.equals("a")) && player1.getX()-1>-1)
            player1.setX(player1.getX()-1);
        else if( (readIn.equals("D")||readIn.equals("d")) && player1.getX()+1<4)
            player1.setX(player1.getX()+1);
        else
        {   System.out.println("~~~ERROR~TRY~AGAIN~~~");
            return false;
        }
        return true;
    }
    public void GoblinMove()
    {
        //int next=(int) (Math.random())%4;
        int x=player1.getX()- player2.getX();
        int y=player1.getY()- player2.getY();
        if( y<0 && player2.getY()-1>-1)//up
            player2.setY(player2.getY()-1);
        else if( y>0 && player2.getY()+1<4 )//down
            player2.setY(player2.getY()+1);
         if( x<0 && player2.getX()-1>-1)//right
            player2.setX(player2.getX()-1);
        else if( x>0 && player2.getX()+1<4)//left
            player2.setX(player2.getX()+1);
    }
    public boolean collide()
    {   int gem=(int) (Math.random()*10);
        if (player1.getX()== player2.getX() && player1.getY()== player2.getY())
        {   System.out.println("!!!!fight!!!!!!!");
            while(1==1)
            {   int dam1=(int) (Math.random()*10);
                int dam2=(int) (Math.random()*10);
                if(player1.getAttack(dam1))
                {   System.out.println("Human die!");
                    System.out.println(player1.toString());
                    System.out.println(player2.toString());
                    return false;
                }
                else if (player2.getAttack(dam2))
                {   System.out.println("Goblin die!!");
                    if(gem%2==1)
                        player1.setGen(player1.getGen()+gem);
                    System.out.println(player1.toString());
                    System.out.println(player2.toString());
                    player2 =new Goblins(dam1%4,dam2%4,100);
                    break;
                }
            }
        }
        return true;
    }

}
