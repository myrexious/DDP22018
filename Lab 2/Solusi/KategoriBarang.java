import java.util.Scanner;

public class KategoriBarang{
	public static void main(String[] args){
		System.out.println("Selamat datang ! Silahkan masukkan nama barang :");
			Scanner input = new Scanner(System.in);									//Input
			String temp;
			while(true){
				temp = input.nextLine();											//Input Assignment
				if(temp.equalsIgnoreCase("selesai")){
					System.out.println("Terimakasih sudah belanja di QuantaMart!");	//Jika user menginput "selesai" maka input ditutup & program dihentikan
					input.close();
					break;
				} 
				else{
					int hasil = encode(temp);
					if(0<=hasil && hasil<=4){										//Jika 0<=hasil perhitungan<=4 maka kategori Lucu
						System.out.println(temp + " adalah barang Lucu");
					} else if(5<=hasil && hasil<=10){								//Jika 5<=hasil perhitungan<=10 maka kategori Unik
						System.out.println(temp + " adalah barang Unik");
					} else if(11<=hasil && hasil<=14){								//Jika 11<=hasil perhitungan<=15 maka kategori Langka
						System.out.println(temp + " adalah barang Langka");
					}
				}
			}	
			
	}
	//perhitungan untuk mementukan kategori barang
	public static int encode(String inp){
		int res = 0;
		for(int i = 0; i<=inp.length()-1; i++){
			int chr = (int) inp.charAt(i);					//mengambil karakter dari string
			double tempres = Math.floor(chr * Math.PI);		//mengalikan dengan pi lalu di floor
			int tempresint = (int) tempres;					//mengubah menjadi type tempres menjadi int
			res += tempresint;								//penambahan seluruh karakter
			}
		int hasil = res%15;									//hasil perhitungan di mod dengan 15
		return hasil;
	}
	
}