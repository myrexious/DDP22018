/*
 * 	akutu cape kak 
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

//ANGGOTAAAAA
public class Anggota extends Pengguna implements Chatable{

	private long poin;
	private LevelKeanggotaan levelKeanggotaan;
	private ArrayList<Chat> chatList;
	private ArrayList<Alamat> alamatList;
	private ArrayList<Pemesanan> pemesananList;
	private ArrayList<Orderable> orderableList;
	private ArrayList<Barang> lendList, barangList, barangDipegangList;
	private static int id;
	private int idAnggota;
	private double duitBGST;
	
	//CONSTRUCTORRR OYEEEE 
	public Anggota(long nomorKTP, String namaLengkap,
	               String email, LocalDate tanggalLahir,
	               String nomorTelepon, long poin,
	               LevelKeanggotaan levelKeanggotaan) {
		super(nomorKTP, namaLengkap, email, tanggalLahir, nomorTelepon);
		this.poin = poin;
		this.levelKeanggotaan = levelKeanggotaan;
		this.chatList = new ArrayList<>();
		this.alamatList = new ArrayList<>();
		this.pemesananList = new ArrayList<Pemesanan>();
		this.orderableList = new ArrayList<Orderable>();
		this.lendList = new ArrayList<Barang>();
		this.barangList = new ArrayList<Barang>();
		this.barangDipegangList = new ArrayList<Barang>();
		this.duitBGST = 0;
		id += 1;
	}

	//NGECHAATT (CIE JOMBLO NGECHAT ADMIN TOKOPEDIA DOANG HUEHUEHUE)
	public void chat(Admin admin, String msg){
		System.out.printf("Anggota %s melakukan chat dengan admin %s \n", this.namaLengkap, admin.getName());
		Chat temp_chat = new Chat(msg, LocalDateTime.now(), this, admin);
		this.chatList.add(temp_chat);
		admin.getChatList().add(temp_chat);
	}

	//NGAMBIL CHATLISTNYAAA HUEHUEHUEEEE *MENGENANG DULU CHAT AMA PACAR*
	public ArrayList<Chat> getChatList(){
		return this.chatList;
	} 

	//MESEN BARANG KOK RIBET AMAT YAK? PERASAAN KALO BARANG GABISA MINJEM DAH
	public void doOrder(int id, ArrayList<Barang> barangList, int lamasewa, ArrayList<InfoBarangLevel> infoList){
		id = this.idAnggota++;		//ID SPECIAL (KAMUNYA SPESIAL GA???)
		System.out.printf("Anggota %s memesan barang\n", this.namaLengkap);
		this.barangList.addAll(barangList);	//MASUKINN BARANGLIST KE BARANG

		//HARGANYA CUUUYYY
		long ongkos = 0;
		long hargaSewa = 0;
		for(InfoBarangLevel b : infoList){
			ongkos += b.getOngkos();
			hargaSewa += b.getHargaSewa();
		}
		hargaSewa *= lamasewa;

		//PESENAN MASUKIN KE DAFTAR PESENAN (I WONDER THO)
		Pemesanan temp_pemesanan = new Pemesanan(id, LocalDateTime.now(), barangList.size(),
		hargaSewa, ongkos, this, new Status("Dipesan"));
		this.pemesananList.add(temp_pemesanan);
		this.orderableList.add(temp_pemesanan);
		
		/* INI NGECEK BARANGNYA ADA ATO NGGA
		 * IYA TAU HARUSNYA MASUK METHOD BIAR CANTIK
		 * TAPI KETIDAKSEMPURNAAN ADALAH KESEMPURNAAN YANG TERSEMBUNYI
		 * 'akutu cape ka'
		 */
		Boolean barangAvailable = false;
		for(Barang x : barangList){
			ArrayList<Barang> listBarangWH = x.getItem().getBarangList();
			if(listBarangWH.isEmpty() || !listBarangWH.contains(x)){
				pemesananList.remove(pemesananList.size()-1);
				Admin randomAdmin = Admin.administrator.get(new Random().nextInt(Admin.administrator.size()));
				randomAdmin.chat(this, "Barang tak tersedia");
				System.out.println("Barang tak tersedia, Pemesanan Pre-Order dipasang?");
				continue;
			} else if(listBarangWH.contains(x)){
				for(Barang y : listBarangWH)
					if(barangAvailable == true){
						break;
					} else if(y.isEqual(x) && y.getStatus().toString().equals("Tersedia")){
						y.setStatus(new Status("Dipesan"));
						y.setPenyewa(this);
						Admin randomAdmin = Admin.administrator.get(new Random().nextInt(Admin.administrator.size()));
						randomAdmin.confirm(this);
						System.out.printf("Pemesanan dengan ID[%d] dipesan oleh anggota %s\n", id, this.namaLengkap);
						barangAvailable = true;
					}	
			}
		}
		//NAMBAHIN POIN (BIAR IBU-IBU SENENG)
		if(barangAvailable){
			this.poin+=10;
			updateLevel();
			for(Barang n : barangList){
				temp_pemesanan.addListBarang(n);
			}
		}
	}
	
	//MELIHAT ORDERAN DAN MELIHAT DUIT YANG TERKURAS
	public void seeOrders(){
		if(pemesananList.size()!=0)
		for(Orderable pesan : orderableList){
			System.out.println(pesan);
		} else {
			System.out.println("Anggota "+this.namaLengkap+" belum memesan apapun");
		}
	}

	//KIRIMMMMMM HEHUEHUEHUEHUEHUEUEHUEUHEHUEHU
	public void doSend(int id, Pemesanan pemesanan, String metode, long ongkos, LocalDate time, Alamat alamat){
		id = this.idAnggota++;
		for(Barang x : lendList){
			if(x.getStatus().toString().equals("Dipesan")){
				//Masukkin ke OrderableList biar bisa diliat di SeeOrder
				Pengiriman temp_pengiriman = new Pengiriman(id, pemesanan, metode, ongkos, time, alamat);
				this.orderableList.add(temp_pengiriman);
				System.out.println("Anggota "+this.namaLengkap+" mengirim barang");
				System.out.println("Pengiriman dengan nomor resi ["+id+"] dikirim oleh anggota "+this.namaLengkap);
				pemesanan.setStatus(new Status("Dikirim"));
				x.setStatus(new Status("Dipinjam"));
				
				//ROYALTIIIIII~~~~ WOOOH
				if(this.levelKeanggotaan.toString().equals("Gold")){
					this.duitBGST += (double) 0.15 * pemesanan.getHargaSewa();
				} else if (this.levelKeanggotaan.toString().equals("Silver")){
					this.duitBGST += (double) 0.1 * pemesanan.getHargaSewa();
				} else if (this.levelKeanggotaan.toString().equals("Bronze")){
					this.duitBGST += (double) 0.05 * pemesanan.getHargaSewa();
				}

				x.getPenyewa().addOrderableListPengiriman(temp_pengiriman);

			} else {
				System.out.println("Tak ada barang yang dipesan kepada "+this.namaLengkap);
			}
		}
	}

	//BALIKINNN BARANGNYA!!11!!1!
	public void doReturn(int id, Pemesanan pemesanan, String metode, long ongkos, LocalDate time, Alamat alamat){
		id = this.idAnggota++;
		if(pemesanan.getStatus().toString().equals("Dikirim")){
			this.orderableList.add(new Pengembalian(id, pemesanan, metode, ongkos, time, alamat));
			System.out.println("Anggota "+this.namaLengkap+" mengembalikan barang");
			System.out.println("Pengembalian dengan nomor resi ["+id+"] dikembalikan oleh anggota "+this.namaLengkap);
			pemesanan.setStatus(new Status("Dikembalikan"));
			//BALIKIN STATUS BARANGNYA KE TERSEDIA HUEHUEHUEHUE
			for(Barang x : pemesanan.getListBarang()){
				x.setStatus(new Status("Tersedia"));
			}
		} else {
			System.out.println("Barang milik "+this.namaLengkap+" tidak ada atau belum dikirim");
		}
	}

	//PINJEMIN BARANGG
	public void lend(Item item, String warna, String urlFoto, String kondisi, int lamaPenggunaan){
		Barang temp_barang = new Barang(item, warna, urlFoto, kondisi, lamaPenggunaan, new Status("Tersedia"));
		item.addBarang(temp_barang);
		System.out.println("Anggota : "+this.namaLengkap+" menitipkan barang.");
		this.poin += 10;
		this.lendList.add(temp_barang);
		updateLevel();
	}

	//KALO POINNYA TINGGI NAIK LEVEL (YEY!)
	public void updateLevel(){
		if(this.poin>=1000){
			this.levelKeanggotaan = new LevelKeanggotaan("Gold", 1000, "Gold Level");
		}else if(this.poin>=500){
			this.levelKeanggotaan = new LevelKeanggotaan("Silver", 500, "Silver Level");
		}else if(this.poin>=250){
			this.levelKeanggotaan = new LevelKeanggotaan("Bronze", 250, "Bronze Level");
		}
	}

	//REVIEW BARANG BIAR KAYA MAKEUPGURU
	public void doReview(Barang barang, String reviewString){
		if(this.barangList.contains(barang)){
			barang.addReview(reviewString);
		} else {
			System.out.println("Anggota belum pernah menyewa barang ini");
		}
	}
	
	//GETTER ALAMATLIST
	public ArrayList<Alamat> getAlamatList(){
		return this.alamatList;
	}

	//GETTER PEMESANANLIST
	public ArrayList<Pemesanan> getPemesananList(){
		return this.pemesananList;
	}

	//NAMA ANGGOTANYA
	public String getName(){
		return this.namaLengkap;
	}

	//ORDERABLELISTBUATPENGIRIMAN
	public void addOrderableListPengiriman(Pengiriman pengiriman){
		this.orderableList.add(pengiriman);
	}
}
