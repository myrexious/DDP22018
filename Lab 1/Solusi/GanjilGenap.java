public class GanjilGenap{
	public static void main(String[] args){
		int nomorPlat = 5347;
		//Jika nomorPlat lebih dari 9999 atau kurang dari 0
		if(nomorPlat > 9999 || nomorPlat < 0){
			System.out.println("Nomor plat anda salah.");
		}
		//jika nomorPlat bisa dibagi dua maka genap
		else if(nomorPlat%2==0){
			System.out.println("Nomor plat anda genap.");
		}
		//jika nomorPlat tak bisa dibagi dua
		else{
			System.out.println("Nomor plat anda ganjil.");
		}
	
	}
}