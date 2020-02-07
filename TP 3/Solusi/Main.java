import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		LevelKeanggotaan levelGold = new LevelKeanggotaan("Gold", 1000, "Gold level");
		LevelKeanggotaan levelSilver = new LevelKeanggotaan("Silver", 500, "Silver level");
		LevelKeanggotaan levelBronze = new LevelKeanggotaan("Bronze", 250, "Bronze level");
		// Pengguna penggunaBruce = new Pengguna(123, "Bruce",
		//		"bruce@mail.com", LocalDate.of(1999, 8, 1),
		//		"+621919912");
		// Akan error jika di-uncomment. Gunakan fakta tersebut untuk membuat class atau interface yang tepat.

		Admin adminJoe = new Admin(123, "Joe",
				"joe@mail.com", LocalDate.of(1999, 8, 1),
				"+62191991");
		Anggota anggotaSteve = new Anggota(444, "Steve",
				"steve@cap.mail", LocalDate.of(2003, 9, 1),
				"+62185938", 1000, levelGold);
		Anggota anggotaBodoAmat = new Anggota(444, "Bodo",
				"bodo@cap.mail", LocalDate.of(2003, 9, 1),
				"+62185938", 1000, levelGold);

		// Tes fungsionalitas chat
		anggotaSteve.chat(adminJoe, "Salam kenal, min");
		// SHOULD PRINT "Anggota Steve melakukan chat dengan admin Joe"
		anggotaSteve.chat(adminJoe, "Apa kabar?");
		// SHOULD PRINT "Anggota Steve melakukan chat dengan admin Joe"
		for (Chat chat : anggotaSteve.getChatList()) {
			System.out.println(chat);
		}
		/* SHOULD PRINT THESE: *REVISED*
		 * "From: Steve - To: Joe, Pesan: Salam kenal, min"
		 * "From: Steve - To: Joe, Pesan: Apa kabar?"
		 */

		ArrayList<Barang> barangList = new ArrayList<>();
		ArrayList<InfoBarangLevel> infoBarangLevelList = new ArrayList<>();

		Item topi = new Item("Topi", "A hat", 5, 12, "Katun premium");
		Barang topiMerah = new Barang(topi, "Merah",
				"http://example.com/hat.png",
				"Nice", 1);
		Barang topiHitam = new Barang(topi, "Hitam",
				"http://example.com/hat.png",
				"Gud", 1);
		topi.addBarang(topiMerah);
		topi.addBarang(topiHitam);
		barangList.add(topiMerah);
		barangList.add(topiHitam);

		InfoBarangLevel infoTopiMerah = new InfoBarangLevel(topiMerah, levelGold, 3000, 10);
		// 3000 menandakan harga sewa per pekan (mengikuti contoh pada deskripsi sistem), 10 menandakan persentase loyalti
		infoTopiMerah.setOngkos(10000);
		InfoBarangLevel infoTopiHitam = new InfoBarangLevel(topiHitam, levelGold, 4000, 15);
		infoTopiHitam.setOngkos(10000);
		infoBarangLevelList.add(infoTopiMerah);
		infoBarangLevelList.add(infoTopiHitam);

		anggotaBodoAmat.lend(topi, "Merah", "http://example.com/hat.png", "Nice", 1);
		anggotaBodoAmat.lend(topi, "Hitam", "http://example.com/hat.png", "Gud", 1);
		// Tes fungsionalitas pemesanan barang
		anggotaSteve.doOrder(100, barangList, 3, infoBarangLevelList);
		// 3 menandakan lama sewa
		// SHOULD PRINT "Anggota Steve memesan barang"
		anggotaSteve.seeOrders();
		// SHOULD PRINT "Pemesanan dengan ID[100] dipesan oleh anggota Steve"
		// SHOULD PRINT "PEMESANAN [2019-04-26T00:21:36.014346800] - Kuantitas: 2 - Harga Sewa: 21000 - Ongkos: 20000 - Status: Dipesan"

		Chatable anggotaScott = new Anggota(443, "Scott",
				"scott@ant.mail", LocalDate.of(2002, 9, 1),
				"+6218885938", 100, levelGold);
		// Chatable chatable = new Chatable();
		// Akan error jika di-uncomment. Gunakan fakta tersebut untuk membuat class atau interface yang tepat.

		((Anggota) anggotaScott).seeOrders();
		// SHOULD PRINT "Anggota Scott belum memesan apapun"

		Alamat alamatSteve = new Alamat(anggotaSteve, "Brooklyn", "Hope St.", 99, "NYC", 240419);
		anggotaSteve.getAlamatList().add(alamatSteve);

		Pemesanan pemesananSteve = (Pemesanan) anggotaSteve.getPemesananList().get(0);

		// Tes fungsionalitas pengiriman
		anggotaBodoAmat.doSend(9991, pemesananSteve,
				"Metode cepat", pemesananSteve.getOngkos(),
				LocalDate.now(), alamatSteve);
		// SHOULD PRINT "Anggota Steve mengirim barang"
		// SHOULD PRINT "Pengiriman dengan nomor resi [9991] dikirim oleh anggota Steve"
		
		// Tes fungsionalitas pengembalian
		anggotaBodoAmat.doReturn(9992, pemesananSteve,
				"Metode cepat", pemesananSteve.getOngkos(),
				LocalDate.now(), alamatSteve);
		// SHOULD PRINT "Anggota Steve mengembalikan barang
		// SHOULD PRINT "Pengembalian dengan nomor resi [9992] dikembalikan oleh anggota Steve

		anggotaSteve.seeOrders();
		// SHOULD PRINT "PEMESANAN [2019-04-26T11:10:05.329213600] - ID: 100 - Kuantitas: 2 - Harga Sewa: 21000 - Ongkos: 20000 - Status: Dipesan"
		// SHOULD PRINT "PENGIRIMAN [2019-04-26] - Nomor Resi: 9991 - Metode: Metode cepat - Pemesan: Steve - Alamat: [Brooklyn, Hope St., 99, NYC, 240419]"
		// SHOULD PRINT "PENGEMBALIAN [2019-04-26] - Nomor Resi: 9992 - Metode: Metode cepat - Pemesan: Steve - Alamat: [Brooklyn, Hope St., 99, NYC, 240419]"
	}
}
