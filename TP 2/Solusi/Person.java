/**
 * kelas Person digunakan untuk menyimpan informasi
 * setiap orang pada piramida manusia
 */
public class Person {

    private Integer weight;
    private String name;
    private Double totalWeight;

    /*Constructor
     */
    public Person(int w, String n, double t) {
        this.weight = w;
        this.name = n;
        this.totalWeight = t;
    }

    /*accessor Weight
     */
    public int getWeight() {
        return this.weight;
    }

    /*setter Weight
     */
    public void setWeight(int w) {
        this.weight = w;
    }

    /*accessor Nama
     */
    public String getName() {
        return this.name;
    }

    /*setter Nama
     */
    public void setName(String n) {
        this.name = n;
    }

    /*accessor totalWeight
     */
    public Double getTotalWeight() {
        return this.totalWeight;
    }

    /*setter totalWeight
     */
    public void setTotalWeight(Double t) {
        this.totalWeight = t;
    }
}
