package com.company;

import java.net.StandardSocketOptions;

public class Goblins {
    private int x, y, health;
    public Goblins(int x, int y, int health)
    {   this.x=x;
        this.y=y;
        this.health=health;
    }
    public boolean getAttack(int in)
    {   //System.out.println("Human attack Goblins with "+ in+" damage");
        this.health-=in;
        return this.health<=0;
    }
    public void move(int x, int y)
    {   this.x=x;
        this.y=y;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public void setX(int in){this.x=in;}
    public void setY(int in){this.y=in;}

    @Override
    public String toString()
    {return "this Goblins at x="+this.x+" y="+this.y+" Health="+this.health;
    }
}
