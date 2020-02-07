public class PembagianManual{
	public static void main(String[] args){
		int pembagi, angka, angkaAwal, hasil, sisa; //deklarasi tipe variabel
		angka = 30;
		angkaAwal = angka;
		pembagi = 4;
		hasil = 0;
		sisa = 0;
		
		//selama angka-pembagi masih bersisa maka akan dikurangi terus
		while((angka-pembagi)>=0){
			angka -= pembagi;
			sisa = angka;
			hasil += 1;
			}
		
		//output hasil
		System.out.println("Hasil pembagian " + angkaAwal + " dengan " + pembagi + " adalah " + hasil + " dengan sisa " + sisa);

	}
}