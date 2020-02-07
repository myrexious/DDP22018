public class Television{
	private int channel = setChannel(7);
	public Television(int channel){
		this.channel = channel;
		System.out.print(channel + " ");
	}

	public int setChannel(int channel){
		this.channel = channel;
		System.out.print(channel + " ");
		return channel;
	}
}