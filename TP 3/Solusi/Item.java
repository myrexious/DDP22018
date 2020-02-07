import java.util.ArrayList;
import java.util.List;

//POKOKNYA ITEM ISINYA ITU BARANG
public class Item {

	private String nama;
	private String deskripsi;
	private int usiaDari;
	private int usiaSampai;
	private String bahan;
	private ArrayList<Barang> barangList;

	//CONSTRUCTOR
	public Item(String nama, String deskripsi, int usiaDari, int usiaSampai, String bahan) {
		this.nama = nama;
		this.deskripsi = deskripsi;
		this.usiaDari = usiaDari;
		this.usiaSampai = usiaSampai;
		this.bahan = bahan;
		this.barangList = new ArrayList<>();
	}

	//MASUKIN BARANG KE ITEM
	public void addBarang(Barang barang){
		this.barangList.add(barang);
	}

	//NGAMBIL LIST BARANG
	public ArrayList<Barang> getBarangList(){
		return this.barangList;
	}

	//GETTER NAMA ITEMNYA
	public String getNama(){
		return this.nama;
	}
}
