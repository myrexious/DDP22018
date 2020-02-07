public class Vehicle{
	public boolean used;
	public String make;
	public static void main(String [] args){
		Vehicle v = new Vehicle();
		if(v.used){
			System.out.println(v.make);
			} else {
				System.out.println(v.make.length());
			}
	}
}