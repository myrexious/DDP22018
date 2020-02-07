public class LevelKeanggotaan {

	// Attribute-attribute yang diperlukan sepertinya ini saja yang ssaya tau 

	private String namaLevel, deskripsi;
	private long minimumPoin;

	//ini kayaknya buat royalti dan duit (mungkin)
	public LevelKeanggotaan(String namaLevel, long minimumPoin, String deskripsi) {
		this.namaLevel = namaLevel;
		this.minimumPoin = minimumPoin;
		this.deskripsi = deskripsi;
	}

	public String toString(){
		return this.namaLevel;
	}

}