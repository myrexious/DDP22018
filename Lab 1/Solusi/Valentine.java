import java.util.Scanner;

public class Valentine{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); //membuat input
		System.out.println("Kepada siapa kamu mau memberi cokelat?");
		String nama = input.nextLine(); //nama menggunakan input jenis string
		System.out.println("Seberapa banyak cokelat dapat kamu berikan?");
		int jumlah = input.nextInt(); //jumlah menggunakan input jenis integer
		//jika jumlah kurang dari sama dengan 10 output, ditolak
		if(jumlah<=10){
			System.out.println("Sayang sekali cokelatmu ditolak oleh " + nama);
			}
		//jika jumlah lebih dari 10, diterima
		else{
			System.out.println("Selamat, cokelatmu diterima oleh " + nama);
			}
		}
	
	}