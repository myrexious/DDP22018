/*
 *YATUHAN INI BUAT APA SAYA BINGUNG
 */
public class InfoBarangLevel {

	private Barang barang;
	private LevelKeanggotaan level;
	private long hargaSewa;
	private long porsiLoyalti;
	private int ongkos;

	public InfoBarangLevel(Barang barang, LevelKeanggotaan level, long hargaSewa, long porsiLoyalti){
		this.barang = barang;
		this.level = level;
		this.hargaSewa = hargaSewa;
		this.porsiLoyalti = porsiLoyalti;
	}

	public void setOngkos(int ongkos){
		this.ongkos = ongkos;
	}

	public Integer getOngkos(){
		return this.ongkos;
	}

	public Long getHargaSewa(){
		return this.hargaSewa;
	}
}

