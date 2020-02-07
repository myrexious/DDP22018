public class Motorcycle {

    /**
     * TODO implements
     * fuel
     * speed
     * maxFuel
     * name
     */
	private String name;
	private int speed;
	private int fuel;
	private int maxFuel;

    /**
     * TODO Explains
     * @param fuel
     * @param speed
     * @param maxFuel
     * @param name
     */
    public Motorcycle(int fuel, int speed, int maxFuel, String name) {
        this.name = name;
		this.fuel = fuel;
		this.speed = speed;
		this.maxFuel = maxFuel;
		// TODO implements
    }

    /**
     * TODO Explains
     * @param fuel
     */
    public void setFuel(int fuel){
		if(fuel>this.maxFuel){
			this.fuel = this.maxFuel;
		} else if(fuel<=0){
			this.fuel = 0;
		} else {
			this.fuel = fuel;
		}
		// TODO Implements
    }

    /**
     * TODO Explains
     * @return
     */
    public int getFuel() {
        // TODO Implements
        return this.fuel;
    }

    /**
     * TODO Explains
     * @return
     */
    public int getSpeed() {
        // TODO Implements
        return this.speed;
    }

    public int getMaxFuel() {
        // TODO Implements
        return this.maxFuel;
    }

    /**
     * TODO Explains
     * @return
     */
    public String getName() {
        // TODO Implements
        return this.name;
    }

    /**
     * TODO Explains
     * @return
     */
    public String toString() {
        // TODO Implements
		return ("Name: " + this.name + "\n" + "Speed: " + this.speed + "\n" +
		"Fuel: " + this.fuel + "\n" + "Max Fuel: " + this.maxFuel);
    }
}