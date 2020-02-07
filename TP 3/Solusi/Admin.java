import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//ADMINNYA SYAPAA
public class Admin extends Pengguna {

	private List<Chat> chatList;
	public static ArrayList<Admin> administrator = new ArrayList<Admin>();

	//CONSTRUCTOR
	public Admin(long nomorKTP, String namaLengkap, String email, LocalDate tanggalLahir, String nomorTelepon){
		super(nomorKTP, namaLengkap, email, tanggalLahir, nomorTelepon);
		this.chatList = new ArrayList<>();
		administrator.add(this);
	}

	//CHAT ADMIN SAMA PENGGUNA DIAMBIL
	public List<Chat> getChatList(){
		return this.chatList;
	}

	//CIE NGECHAT SAMA ANGGOTA
	public void chat(Anggota anggota, String msg){
		System.out.printf("Admin %s melakukan chat dengan anggota %s \n", this.namaLengkap, anggota.getName());
		Chat temp_chat = new Chat(msg, LocalDateTime.now(), anggota, this);
		this.chatList.add(temp_chat);
		anggota.getChatList().add(temp_chat);
	}

	//ADMIN NGOMONG BARANGNYA ADA POKOKNYA
	public void confirm(Anggota anggota){
		System.out.println("Barang tersedia, pemesanan dibuat.");
	}
}