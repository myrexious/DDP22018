public class Employee{
	
	static public void main(String[] args){
		jawab(8,9,7);
	}
	
	static void jawab(int bil1, int bil2, int bil3){
		if (!(jawabBantu(bil1,bil2,bil3)))
			if (!(jawabBantu(bil2,bil1,bil3)))
				jawabBantu(bil3,bil2,bil1);
	}

	static boolean jawabBantu(int bil1, int bil2, int bil3){
		int min,max,median;
		if (bil1 <= bil2 && bil1 <= bil3){
		min=bil1;
			if (bil2<=bil3){
				median = bil2;
				max = bil3;
			}else{
				median = bil3;
				max = bil2;
			}
		System.out.format("%d %d %d",min, median, max);
		return true;
		} else {
		return false;
		}
	}
}