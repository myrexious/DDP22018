import java.time.LocalDateTime;
import java.util.ArrayList;

//KELAS ORDERABLE
public class Pemesanan implements Orderable {

	private int id;
	private LocalDateTime dateTimePesanan;
	private int kuantitasBarang;
	private long hargaSewa, ongkos;
	private Anggota pemesan;
	private Status status;
	private ArrayList<Barang> listBarang;

	///CONSTRUCTOR
	public Pemesanan(int id, LocalDateTime dateTimePesanan, int kuantitasBarang, long hargaSewa, long ongkos, Anggota pemesan, Status status) {
		this.id = id;
		this.dateTimePesanan = dateTimePesanan;
		this.kuantitasBarang = kuantitasBarang;
		this.hargaSewa = hargaSewa;
		this.ongkos = ongkos;
		this.pemesan = pemesan;
		this.status = status;
		listBarang = new ArrayList<Barang>();
	}

	//GETTER
	public int getID(){
		return this.id;
	}

	//GETTER
	public long getOngkos(){
		return this.ongkos;
	}

	//BUAT DI PRINT
	public String toString(){
		return ("PEMESANAN ["+ this.dateTimePesanan +"] - Kuantitas: "+ this.kuantitasBarang +" - Harga Sewa: "+
				this.hargaSewa +" - Ongkos: "+ this.ongkos +" - Status: "+ this.status);
	}

	//GETTER
	public Status getStatus(){
		return this.status;
	}

	//MENGATUR STATUS
	public void setStatus(Status status){
		this.status = status;
	}

	//SIAPAKAH PEMESSANNYA??? I WONDER
	public Anggota getPemesan(){
		return this.pemesan;
	}

	//HARGASEWANYA BRP DIAMBIL
	public long getHargaSewa(){
		return this.hargaSewa;
	}

	//NAMBAHIN KE LISTBARANG
	public void addListBarang(Barang barang){
		this.listBarang.add(barang);
	}

	//NGAMBIL LIST BARANG
	public ArrayList<Barang> getListBarang(){
		return this.listBarang;
	}

}
