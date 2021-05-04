package com.company;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;

public class Ship extends MainBattleship{
    private int hit;
    private final int end=17;
    private boolean aircraft,battleship,submarine,destroyer,cruiser;
    private String name;
    private String[][] shipMap =new String[][]{ {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
                                                {"~", "~", "~", "~", "~", "~", "~", "~", "~"}
                                                };

    private String[][] battleMap =new String[][]{ {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"~", "~", "~", "~", "~", "~", "~", "~", "~"}
    };

    public Ship(String name)
    {   this.hit=0;
        this.name=name;
        this.aircraft=false;
        this.battleship=false;
        this.submarine=false;
        this.destroyer=false;
        this.cruiser=false;
    }

    private String at(String in)
    {   String ans="what!!";
        if(in.equals("a"))
            ans="Aircraft Carrier";
        else if(in.equals("b"))
            ans="Battleship";
        else if(in.equals("s"))
            ans="Submarine";
        else if(in.equals("d"))
            ans="Destroyer";
        else if(in.equals("c"))
            ans="Cruiser";
        return ans;
    }

    private boolean addShip(int x, int y, String axis, String type, int count)
    {   String error="";
        try {
            if (axis.equals("v") ) {
                for (int i = 0; i < count; i++)
                    if (shipMap[y + i][x] != "~") {
                        error = at(shipMap[y + i][x]);
                        System.out.println(error + " is already located there, enter another location: ");
                        return false;
                    }
                for (int i = 0; i < count; i++)
                    shipMap[y + i][x] = type;
            } else if (axis.equals("h") ) {
                for (int i = 0; i < count; i++)
                    if (shipMap[y][x + i] != "~") {
                        error = at(shipMap[y][x + i]);
                        System.out.println(error + " is already located there, enter another location: ");
                        return false;
                    }
                for (int i = 0; i < count; i++)
                    shipMap[y][x + i] = type;
            }
        }catch (Exception e )
        {   System.out.println("!!out side of map!! ");
            return false;
        }
        return true;
    }

    private ArrayList<Integer> token(String input)
    {   ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<input.length(); i++)
        {   if(input.charAt(i)>'0'&& input.charAt(i) <='9')
                ans.add( input.charAt(i)-'0');
        }
        return ans;
    }

    @Override
    public Boolean attack() {
        System.out.println(this.name+" enter the coordinates for an attack: (x,y)");
        String readIn=new Scanner(System.in).nextLine();
        ArrayList<Integer> read=new ArrayList<>();
        read=token(readIn);
        if(read.size()!=2)return false;
        int x=read.get(0);
        int y=read.get(1);
        if(battleMap[y-1][x-1]=="M"||battleMap[y-1][x-1]=="X")
        {   System.out.println(this.name+" have attack here, enter another location: ");
            return false;
        }
        else if(shipMap[y-1][x-1]!="~")
        {   battleMap[y-1][x-1]="X";
            this.hit++;
            System.out.println(this.name+" hit!!");
            return true;
        }
        System.out.println("You missed!");
        battleMap[y-1][x-1]="M";
        return true;
    }

    @Override
    public Boolean Win()
    {
        return this.hit==this.end;
    }

    @Override
    public Boolean setShipMap()
    {
        ArrayList<Integer> at= new ArrayList<>();
        String readIN="";
        String axis="";
        if(!this.cruiser)
        {   System.out.println(this.name + ", please enter the coordinates for your ships.");
            System.out.println("Enter the coordinates for the Cruiser:(x,y) ");
            readIN = new Scanner(System.in).nextLine();
            at = token(readIN);
            System.out.println("Place horizontally or vertically (h or v)?");
            axis = new Scanner(System.in).nextLine();
            //if (at.size() != 2) return false;
            try {
                if (!addShip(at.get(0) - 1, at.get(1) - 1, axis, "c", 2)) return false;
            }catch (Exception e ){System.out.println("Error on input index try again!!");return false;}
            this.cruiser = true;
            getShipMap();
        }
        if(!this.destroyer)
        {
            System.out.println("Enter the coordinates for the Destroyer:(x,y) ");
            readIN = new Scanner(System.in).nextLine();
            at = token(readIN);
            System.out.println("Place horizontally or vertically (h or v)?");
            axis = new Scanner(System.in).nextLine();
            //if (at.size() != 2) return false;
            if (!addShip(at.get(0) - 1, at.get(1) - 1, axis, "d", 3)) return false;
            getShipMap();
            this.destroyer=true;
        }
        if(!this.submarine)
        {   System.out.println("Enter the coordinates for the Submarine:(x,y) ");
            readIN = new Scanner(System.in).nextLine();
            at = token(readIN);
            System.out.println("Place horizontally or vertically (h or v)?");
            axis = new Scanner(System.in).nextLine();
            //if (at.size() != 2) return false;
            if (!addShip(at.get(0) - 1, at.get(1) - 1, axis, "s", 3)) return false;
            this.submarine=true;
            getShipMap();
        }
        if(!this.battleship)
        {   System.out.println("Enter the coordinates for the Battleship:(x,y) ");
            readIN = new Scanner(System.in).nextLine();
            at = token(readIN);
            System.out.println("Place horizontally or vertically (h or v)?");
            axis = new Scanner(System.in).nextLine();
            //if (at.size() != 2) return false;
            if (!addShip(at.get(0) - 1, at.get(1) - 1, axis, "b", 4)) return false;
            this.battleship=true;
            getShipMap();
        }
        if(!this.aircraft)
        {   System.out.println("Enter the coordinates for the Aircraft Carrier:(x,y) ");
            readIN = new Scanner(System.in).nextLine();
            at = token(readIN);
            System.out.println("Place horizontally or vertically (h or v)?");
            axis = new Scanner(System.in).nextLine();
            //if (at.size() != 2) return false;
            if (!addShip(at.get(0) - 1, at.get(1) - 1, axis, "a", 5)) return false;
            this.aircraft=true;
            getShipMap();
        }
        return true;
    }

    @Override
    public void getBattleMap() {
        System.out.println("  123456789");
        for(int i = 0; i< battleMap.length; i++)
            System.out.println((i+1)+" "+ battleMap[i][0]+ battleMap[i][1]+ battleMap[i][2]+ battleMap[i][3]+ battleMap[i][4]+ battleMap[i][5]+ battleMap[i][6]+ battleMap[i][7]+ battleMap[i][8] );
    }

    @Override
    public void getShipMap()
    {   System.out.println("  123456789");
        for(int i=0; i<shipMap.length; i++)
            System.out.println((i+1)+" "+ shipMap[i][0]+ shipMap[i][1]+ shipMap[i][2]+shipMap[i][3] +shipMap[i][4] +shipMap[i][5]+shipMap[i][6]+shipMap[i][7]+shipMap[i][8]      );
    }
}
