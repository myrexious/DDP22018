public class ManRay extends SuperHero{
    
    public ManRay(String name, int powerLevel) {
        super(name, powerLevel);        //Call SuperHero constructor 
        addPower(new LaserEye());
        addPower(new Strength());
    }

    //Prints out Identity of the hero
    public void identity(){
        System.out.println("It's " + this.getName() + ", the ManRay! It has the power level of " + this.getPowerLevel());
    }
}