import java.util.ArrayList;
import java.util.List;

//POKOKNYA ITU KAN KATEGORI ISINYA ITEM YANG ISINYA BARANG
public class Kategori {

	private String nama;
	private int level;
	private Kategori superKategori;
	private List<Kategori> subKategoriList;
	private ArrayList<Item> itemDalamKategori;

	public Kategori(String nama, int level, Kategori superKategori){
		this.nama = nama;
		this.level = level;
		this.superKategori = superKategori;
		superKategori.getSubKategoriList().add(this);
		subKategoriList = new ArrayList<>();
		itemDalamKategori = new ArrayList<>();
	}

	//getter listnya
	public List<Kategori> getSubKategoriList(){
		return this.subKategoriList;
	}
	
	//masukin item ke kategori
	public void addItemDalamKategori(Item item){
		itemDalamKategori.add(item);
	}
}
