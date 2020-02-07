import java.lang.Comparable;
import java.util.ArrayList;

public abstract class SuperHero implements Comparable<SuperHero>{

    private int powerLevel;
    private String name;
    private ArrayList<Power> powerList = new ArrayList<Power>();;

    //Constructor
    public SuperHero(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    //getter powerLevel
    public int getPowerLevel(){
        return this.powerLevel;
    }

    //getter name
    public String getName(){
        return this.name;
    }

    //adding power to the list
    public void addPower(Power power){
        this.powerList.add(power);
    }

    //to be overriden
    public void identity(){}

    //menunjukkan kekuatan SuperHero
    public void showPowers() {
        System.out.println(".....HEED ME.....");
        System.out.println("FOR MY NAAAAAAAME IS " + getName().toUpperCase());
        System.out.println("TIME TO SHOW YOU MY POWERS");
        for(Power i : powerList){
            i.doPower();
        }
    }

    //Override the default compareTo
    @Override
    public int compareTo(SuperHero o) {
        if(this.powerLevel<o.getPowerLevel()){return -1;}
        else if (this.powerLevel > getPowerLevel()){return 1;}
        else{return 0;}
    }
}