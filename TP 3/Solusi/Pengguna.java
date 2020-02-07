import java.time.LocalDate;

public abstract class Pengguna {

	// TODO tambahkan attribute-attribute yang diperlukan
	// sepertinya ini saja
	protected long nomorKTP;
	protected String namaLengkap;
	protected String email;
	protected LocalDate tanggalLahir;
	protected String nomorTelepon;

	//CONSTRUCTOR PENGGUNA
	public Pengguna(long nomorKTP, String namaLengkap,
	                String email, LocalDate tanggalLahir,
	                String nomorTelepon) {
		this.nomorKTP = nomorKTP;
		this.namaLengkap = namaLengkap;
		this.email = email;
		this.tanggalLahir = tanggalLahir;
		this.nomorTelepon = nomorTelepon;
	}

	//GETTER NAMANYA TU ORANG APAAN
	public String getName(){
		return this.namaLengkap;
	}
}
