import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Pyramid {

    /**
     * pyramidData berisi informasi Person di poin tertentu
     */
    private Person pyramidData[][];

    /**
     * level / tingkat dari piramida manusia yang diinginkan
     */
    private static int level = 0;

    public static void main(String args[]) {

        if (args.length == 0) {
            System.err.println("Anda harus memberikan argument");
            return;
        }

        // objek scanner untuk membaca input dari file
        Scanner input = null;


        // Membuat objek pyramid
        Pyramid pyramid = new Pyramid();

        try {

            level = Integer.parseInt(args[0]);
            pyramid.fillData(level);            // Memanggil fungsi untuk mengisi piramidData dgn data

        } catch (NumberFormatException nfe) {

            // kode untuk membaca file
            try {
                input = new Scanner(new File(args[0]));
                level = Integer.parseInt(input.nextLine());
                pyramid.fillData(level);                                                //Memasukkan nama dan data ke pyramidData

                for (int i = 0; i < level; i++) {
                    String line[] = input.nextLine().split(";");
                    for (int j = 0; j <= pyramid.pyramidData[i].length - 1; j++) {
                        String item[] = line[j].split(" ");
                        pyramid.pyramidData[i][j].setWeight(Integer.parseInt(item[1])); //Mengatur berat dan nama person agar sesuai input
                        pyramid.pyramidData[i][j].setName(item[0]);

                    }
                }


            } catch (FileNotFoundException e) {
                System.out.println("Berkas " + args[0] + " tidak ditemukan.");          //Error berkas tidak ada
                return;
            }
        }

        // cek waktu awal sebelum mencari semua beban
        long startTime = System.currentTimeMillis();

        // melakukan penghitungan computeLoad untuk semua index sambil mencetak ke layar
        pyramid.print();
        for (int i = 0; i < level; i++) {
            for (int j = 0; j <= pyramid.pyramidData[i].length - 1; j++) {
                System.out.printf("%.3f ", pyramid.computeLoad(i, j));
            }
            System.out.println();
        }
        // ambil selisih waktu
        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println("\nProgram selesai : " + estimatedTime + " ms");
        System.out.println("=============================================");

    }

    private double computeLoad(int row, int col) {
        if (row == 0 && col == 0) {
            //Base Case
            return 0.0;
        } else if (col == 0) {
            //Orang berada di pojok kiri
            return 0.5 * (computeLoad(row - 1, col) + this.pyramidData[row - 1][col].getWeight());
        } else if (row == col) {
            //Orang berada di pojok kanan
            return 0.5 * (computeLoad(row - 1, col - 1) + this.pyramidData[row - 1][col - 1].getWeight());
        }
        if (row > 0 && col > 0) {
            //Orang berada di tengah
            return 0.5 * (computeLoad(row - 1, col - 1) + this.pyramidData[row - 1][col - 1].getWeight()
                    + computeLoad(row - 1, col) + this.pyramidData[row - 1][col].getWeight());
        }
        return 0.0;

    }

    /**
     * fungsi ini bertujuan untuk mengisi data pyramidData dengan nilai random
     */
    private void fillData(int level) {
        this.pyramidData = new Person[level][0];
        Random r = new Random();
        String nama = "";
        int berat = 0;
        int count = 0;
        Double totalWeight = 0.0;

        for (int i = 0; i < level; i++) {
            this.pyramidData[i] = new Person[i + 1];
            for (int j = 0; j <= this.pyramidData[i].length - 1; j++) {
                nama = Pyramid.generateName(count++);                              //Nama alfabet
                berat = r.nextInt(50) + 40;                                        //Berat random
                this.pyramidData[i][j] = new Person(berat, nama, totalWeight);     //Membuat objek dan memasukkan ke array
            }
        }
    }

    /**
     * Fungsi ini berguna untuk mencetak piramid ke layar
     */
    private void print() {
        for (Person[] row : this.pyramidData) {
            for (Person p : row) {
                System.out.printf("{%s %d}", p.getName(), p.getWeight());
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Fungsi generateName digunakan untuk men-generate alfabet sesuai dengan
     * urutannya (int)
     */
    private static String generateName(int i) {
        return i < 0 ? "" : generateName((i / 26) - 1) + (char) (65 + i % 26);
    }
}