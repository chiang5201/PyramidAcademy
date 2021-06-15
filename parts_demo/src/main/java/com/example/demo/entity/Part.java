package com.example.demo.entity;

import javax.persistence.*;
@Entity
@Table(name= "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name ="id")
    private int id;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "part_price")
    private int partPrice;

    public Part(){}

    public Part(String partName, int partPrice)
    {   this.partName=partName;
        this.partPrice=partPrice;
    }

    public int getId(){return id; }

    public int getPartPrice(){return partPrice; }

    public String getPartName(){return partName; }

    public void setPartName(String partName) { this.partName = partName; }

    public void setPartPrice(int partPrice) {this.partPrice= partPrice;}

    public void setId(int id){this.id=id;}

    @Override
    public String toString(){
        return "part{"+"id="+id+
                ", Part Name="+ partName+'\''+
                ", Part Price="+ partPrice+'\''+
                "}";
    }
}
