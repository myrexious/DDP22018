import java.time.LocalDate;

//BALIKIIIN
public class Pengembalian implements Orderable{

	private int id;
	private Pemesanan pemesanan;
	private String metode;
	private long ongkos;
	private LocalDate date;
	private Alamat alamat;


	// TODO tambahkan method-method yang diperlukan
	// KAYAKNYA INI DOANG
	// CONSTRUCTOR
	public Pengembalian(int id, Pemesanan pemesanan, String metode, long ongkos, LocalDate date, Alamat alamat){
		this.id = id;
		this.pemesanan = pemesanan;
		this.metode = metode;
		this.ongkos = ongkos;
		this.date = date;
		this.alamat = alamat;
	}

	//BUAT NGEPRINT
	public String toString(){
		return ("PENGEMBALIAN ["+LocalDate.now()+"] - Nomor Resi: "+this.id+" - Metode: "+this.metode+" - Pemesan: "+
				this.pemesanan.getPemesan().getName()+" - Alamat: ["+this.alamat+"]");
	}
}
