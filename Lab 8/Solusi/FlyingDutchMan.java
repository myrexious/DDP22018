public class FlyingDutchMan extends SuperHero{
    
    public FlyingDutchMan(String name, int powerLevel) {
        super(name, powerLevel);        //Call SuperHero constructor 
        addPower(new Flying());
        addPower(new LaserEye());
    }

    //Prints out Identity of the hero
    public void identity(){
        System.out.println("It's " + this.getName() + ", the FlyingDutchMan! It has the power level of " + this.getPowerLevel());
    }
}