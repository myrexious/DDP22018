public class Person {
    private String nama;
    private Kendaraan kendaraan;

    //constructor
    public Person(String nama, Kendaraan kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    //jika user pergi mereturn string "(nama) pergi dari (asal) ke (tujuan) naik (nama kendaraan)"
    public String pergi(String asal, String tujuan, int jarak) {
        return this.nama + " pergi dari " + asal + " ke " + tujuan + " naik " + this.kendaraan.getNama()
                + " dengan biaya " + this.kendaraan.getBiaya(jarak);
    }

    // mengeset kendaraan yang dinaiki seseorang
    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    // getter nama
    public String getNama() {
        return this.nama;
    }
}