import java.util.ArrayList;

public class Circuit {

    /**
     * TODO implements
     * circuitName
     * circuitLength
     * raceCount
     * ArrayList motor
     */
	private ArrayList<Motorcycle> motor;
	private String circuitName;
	private int circuitLength;
	private int raceCount = 0;

    /**
     * TODO Explains
     * @param circuitName
     * @param circuitLength
     */
    public Circuit(String circuitName, int circuitLength) {
        this.circuitName = circuitName;
		this.circuitLength = circuitLength;
		this.motor = new ArrayList<Motorcycle>();
		// TODO implements
    }

    /**
     * TODO Explains
     * @param amount
     */
    public void refuel(int amount) {
		for(Motorcycle i : motor){
			i.setFuel(i.getFuel() + amount);
		}
        // TODO implements
    }

    /**
     * TODO Explains
     * @param motorcycle
     */
    public void addMotorcycle(Motorcycle motorcycle) {
		this.motor.add(motorcycle);
        // TODO implements
    }

    /**
     * TODO Explains
     */
    public void doRace() {
		this.raceCount++;
		Motorcycle win = new Motorcycle(0, 0, 0, "none");
		System.out.println("<<Race " +this.raceCount+ " | " + this.circuitName + " International Circuit>>" + "\n[Winner]");
		for(Motorcycle j : this.motor){
			if(j.getFuel() - this.circuitLength >= 0){
				if(j.getSpeed()>win.getSpeed()){
					win = j;
				}
			}
			j.setFuel(j.getFuel()-this.circuitLength);
			System.out.println(j.getFuel());
		}
		if(win.getName().equals("none")){
			System.out.println("No one can complete this race");
			System.out.println("-------------------------------");
		} else {
			System.out.println(win.toString());
			System.out.println("-------------------------------");
		}
	}
			
		
	
    // TODO implements
    

    /**
     * TODO Explains
     * @return
     */
    public int getCircuitLength() {
		return this.circuitLength;
        // TODO implements
    }

    /**
     * TODO Explains
     * @return
     */
    public String getName() {
		return this.circuitName;
        // TODO implements
    }
}