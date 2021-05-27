package company;

public class HangMan {
   private final String[][] word= new String[][] {  {"c","a","t"},
                                                    {"o","l","d"},
                                                    {"t","r","y"},
                                                    {"n","e","w"},
                                                    {"t","e","a"}
                                                } ;
   private String[][] man;
   private int count;
   private String missing;
   private String[] correctAt;
    HangMan()
    {   this.correctAt=new String[]  {"_","_","_"};
        this.count=0;
        this.missing="";
        this.man= new String[][]{           {" ","+","=","+" },
                                            {" "," "," ","|" },
                                            {" "," "," ","|" },
                                            {" "," "," ","|" },
                                            {"=","=","=","=" }
                                    } ;
    }
    public void  reset()
    {
        this.correctAt=new String[]  {"_","_","_"};
        this.missing="";
        this.count=0;
        this.man= new String[][]{       {" ","+","=","+" },
                                        {" "," "," ","|" },
                                        {" "," "," ","|" },
                                        {" "," "," ","|" },
                                        {"=","=","=","=" }
                                } ;
    }

    public String getMissing() {
        return missing;
    }

    public void drawMan()
    {	switch (count )
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

}
