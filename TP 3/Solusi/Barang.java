import java.util.ArrayList;

//BARANGGGGGGGGGGGGGGGGGGGGGGGGGG
public class Barang {
	
	private Item item;
	private String warna;
	private String urlFoto;
	private String kondisi;
	private int lamaPenggunaan;
	private Anggota penyewa;
	private InfoBarangLevel infoBarangLevel;
	private Status status;
	private ArrayList<String> reviewList;


	//CONSTRUCTOR
	public Barang(Item item, String warna, String urlFoto, String kondisi, int lamaPenggunaan) {
		this.item = item;
		this.warna = warna;
		this.urlFoto = urlFoto;
		this.kondisi = kondisi;
		this.lamaPenggunaan = lamaPenggunaan;
		this.status = new Status("Tidak Tersedia");
		reviewList = new ArrayList<String>();
	}

	//KALO BUAT PENYEWA
	public Barang(Item item, String warna, String urlFoto, String kondisi, int lamaPenggunaan, Status status){
		this(item, warna, urlFoto, kondisi, lamaPenggunaan);
		this.status = new Status("Tersedia");
	}

	//KALO BARANGNYA WARNA SAMA JENISNYA SAMA YA SAMA
	public Boolean isEqual(Barang barang){
		Boolean a = (this.item == barang.item);
		Boolean b = (this.warna == barang.warna);
		if(a==true && b==true) return true;
		return false;
	}

	//MASUKIN REVIEW
	public void addReview(String reviewString){
		reviewList.add(reviewString);
	}

	//LIAT REVIEW ORANG APA AJA
	public void seeReview(){
		System.out.println("Reviews for " + this.getItem().getNama());
		for(int x = 0 ; x < this.reviewList.size() ; x++ ){
			System.out.println(x + ". " + reviewList.get(x));
		}
		System.out.println("----------------------------------");
	}

	//GETTER TERMASUK ITEM APA
	public Item getItem(){
		return this.item;
	}

	//GETTER WARNANYA APA
	public String getWarna(){
		return this.warna;
	}

	//SETTER SIAPA YANG NYEWA
	public void setPenyewa(Anggota anggota){
		this.penyewa = anggota;
	}

	//GETTER SIAPA YANG NYEWA
	public Anggota getPenyewa(){
		return this.penyewa;
	}

	//GETTER STATUSNYA NI BARANG TUH APAAN
	public Status getStatus(){
		return this.status;
	}

	//NGATUR NI BARANG BISA DIPINJEM, LAGI DIKIRIM ATO APA
	public void setStatus(Status status){
		this.status = status;
	}
}
