public class DirtyBubble extends SuperHero{
    
    public DirtyBubble(String name, int powerLevel) {
        super(name, powerLevel);        //Call SuperHero constructor 
        addPower(new Strength());
        addPower(new Flying());
    }

    //Prints out Identity of the hero
    public void identity(){
        System.out.println("It's " + this.getName() + ", the DirtyBubble! It has the power level of " + this.getPowerLevel());
    }
}