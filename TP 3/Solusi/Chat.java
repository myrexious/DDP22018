import java.time.LocalDateTime;

//CLASS BUAT NGCHAT
public class Chat {

	private String pesan;
	private LocalDateTime dateTime;
	private Anggota anggota;
	private Admin admin;

	//CONSTRUCTOR
	public Chat(String msg, LocalDateTime time, Anggota member, Admin admin){
		this.pesan = msg;
		this.dateTime = time;
		this.anggota = member;
		this.admin = admin;
	}

	//POKOKNYA BUAT KALO DI PRINT
	public String toString(){
		return String.format("From: %s - To: %s, Pesan: %s", this.anggota.getName(), this.admin.getName(), this.pesan);
	}
}