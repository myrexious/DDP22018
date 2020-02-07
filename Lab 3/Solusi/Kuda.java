import java.util.Scanner;

public class Kuda{
 public static void main(String[] args){
	 //prompt banyak kotak
	System.out.println("Masukkan ukuran catur:");
	Scanner input1 = new Scanner(System.in);
	int n = Integer.parseInt(input1.nextLine());
	
	//user input isi chessboard
	String[][] board = new String[n][n];
	for(int i=0; i<n;i++){
		String nxn = input1.nextLine();
		board[i] = nxn.split(" ");			//memasukkan isi chessboard ke array
	}
	
	//menentukan tmpt kuda
	int[] posh = new int[2];
	for(int a=0; a<n; a++){
		for(int b=0; b<n; b++){
			if((board[a][b]).equals("H")){
				posh[0]=a;					//posisi x kuda
				posh[1]=b;					//posisi y kuda
				
			}
		}
	}
	
	//mengecek lokasi pion
	int count=0;
	for(int x=0; x<n; x++){
		for(int y=0; y<n; y++){
			if((board[x][y]).equals("P")){
				if(Math.abs(x-posh[0])==2&&Math.abs(y-posh[1])==1||Math.abs(y-posh[0])==2&&Math.abs(x-posh[1])==1)		//perhitungan jarak dengan kuda
				{count++;}	//jika jarak tepat, kuda bisa makan pion
			}
		}
	}
	System.out.println("Banyaknya bidak catur yang dapat dimakan kuda:");
	System.out.println(count);
	input1.close();
	}
}