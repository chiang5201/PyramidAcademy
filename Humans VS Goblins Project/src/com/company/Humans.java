package com.company;

public class Humans {
    private int x, y, health;
    private int gen;
    public Humans(int x, int y, int health)
    {   this.x=x;
        this.y=y;
        this.health=health;
        this.gen =0;
    }
    public boolean getAttack(int in)
    {   //System.out.println("Goblins attack Humans with "+ in+" damage");
        this.health-=in;
        return this.health<=0;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getGen(){return this.gen;}
    public void setX(int in){this.x=in;}
    public void setY(int in){this.y=in;}
    public void setGen(int in){this.gen =in;}
    @Override
    public String toString()
    { return "this humans at x="+this.x+" y="+this.y+" Health="+this.health+" gen="+ gen;
    }
}
