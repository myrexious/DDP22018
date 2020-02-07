//superclass macam-macam kendaraan
public class Kendaraan {
    private String nama;

    //constructor
    public Kendaraan(String nama) {
        this.nama = nama;
    }

    //getter nama kendaraan
    public String getNama() {
        return nama;
    }

    public int getBiaya(int jarak) {
        return 0;
    }

}

//class Mobil merupakan sub-class dari Kendaraan
class Mobil extends Kendaraan {

    //constructor
    public Mobil(String nama) {
        super(nama);
    }

    @Override
    //biaya menggunakan Mobil
    public int getBiaya(int jarak) {
        return jarak * 100000;
    }
}

//class Motor merupakan sub-class dari Kendaraan
class Motor extends Kendaraan {

    //constructor
    public Motor(String nama) {
        super(nama);
    }

    @Override
    //biaya menggunakan Motor
    public int getBiaya(int jarak) {
        return jarak * 5000;
    }
}

//class Pesawat merupakan sub-class dari Kendaraan
class Pesawat extends Kendaraan {

    //constructor
    public Pesawat(String nama) {
        super(nama);
    }

    @Override
    //biaya menggunakan Pesawat
    public int getBiaya(int jarak) {
        return jarak * 1000000;
    }
}