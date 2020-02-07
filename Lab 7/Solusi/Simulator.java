public class Simulator {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("GO-CAR");          //instansiasi objek Mobil
        Motor motor = new Motor("GO-JEK");          //instansiasi objek Motor
        Pesawat pesawat = new Pesawat("GO-PLANE");  //instansiasi objek Pesawat

        Person dafa = new Person("Dafa", motor);    //instansiasi objek Person bernama Dafa
        Person emma = new Person("Emma", mobil);    //instansiasi objek Person bernama Emma

        System.out.println(dafa.pergi("Kutek", "Pacil", 10));
        System.out.println(emma.pergi("Jakarta", "Bandung", 150));

        dafa.setKendaraan(pesawat);
        System.out.println(dafa.pergi("Kutek", "Pacil", 10));

    }
}