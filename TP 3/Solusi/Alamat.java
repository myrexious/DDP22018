//Alamat orang
public class Alamat {

	private Anggota pemilik;
	private String namaAlamat;
	private String jalan;
	private long nomor;
	private String kota;
	private int kodePos;

	public Alamat(Anggota pemilik, String namaAlamat, String jalan, long nomor, String kota, int kodepos){
		this.pemilik = pemilik;
		this.namaAlamat = namaAlamat;
		this.jalan = jalan;
		this.nomor = nomor;
		this.kota = kota;
		this.kodePos = kodepos;
	}

	//kalo ngeprint
	public String toString(){
		return (this.namaAlamat + ", " + this.jalan + ", " + this.nomor + ", " + this.kota + ", " + this.kodePos);
	}

	//alamatnya syapa
	public Anggota getPemilik(){
		return this.pemilik;
	}
}
