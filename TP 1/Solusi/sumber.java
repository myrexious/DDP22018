import java.util.Scanner;

public class sumber{
    public static void main(String[] args){
        System.out.println("Masukkan nomor pada kartu kredit sebagai bilangan bulat long:");    //user input
        Scanner input = new Scanner(System.in);
        long angka = input.nextLong();
        if(isValid(angka)==true){                                                               //validity check
            System.out.println("Nomor kartu "+angka+" valid.");
        } else {
            System.out.println("Nomor kartu "+angka+" tidak valid.");}
        input.close();
    }

    /**Mengembalikan nilai true jika nomor pada kartu kredit valid**/
    public static boolean isValid(long number){
        if(getSize(number)>16||getSize(number)<13){                                         //checks credit card numbers length
            return false;
        } else if((sumOfDoubleEvenPlace(number)+sumOfOddPlace(number))%10!=0){              //checks the sum of odd and even place
            return false;
        } else if(prefixMatched(number, 4)==true || prefixMatched(number, 5)==true ||       //checks the prefix if it contains either 4,5,6,or37
        prefixMatched(number, 6)==true || prefixMatched(number, 37)==true){
            return true;
        } else {
            return false;
        }
    }

    /** Mengembalikan hasil dari Langkah 2**/
    public static int sumOfDoubleEvenPlace(long number){
        int resEven = 0;
        String numberStr = Long.toString(number);                                   //changes long to string
        for(int i=0 ; i < getSize(number); i+=2){                                   //from 0 then add 2 continuously
            resEven += getDigit(Character.getNumericValue(numberStr.charAt(i))*2);  //changes char from string to int and adding it together
        }
        return resEven;
    }
    
    /** Mengembalikan bilangan number jika hanya terdiri dari satu digit; 
    jika tidak, kembalikan hasil jumlah kedua digitnya **/
    public static int getDigit(int number){
        if(number>9){return (number%10)+(number/10);}           //adding the first digit (number/10 on int base) with the second digit (number%10)
        else{return number;}                                                        
    }

    /** Mengembalikan hasil jumlah digit-digit pada posisi ganjil pada number **/
    public static int sumOfOddPlace(long number){
        int resOdd = 0;
        String numberStr = Long.toString(number);
        for(int j=1 ; j < getSize(number); j+=2){                                   //from 1 then add 2 continuously
            resOdd += Character.getNumericValue(numberStr.charAt(j));               //changes char from string to int and adding it together
        }
        return resOdd;
    }
    
    /** Mengembalikan nilai true jika digit-digit d adalah prefiks /
    awalan dari bilangan number **/
    public static boolean prefixMatched(long number, int d){
        if(getPrefix(number, Integer.toString(d).length())==d){         //checks the prefix
            return true;
        } else {
            return false;
        }
    }
    
    /** Mengembalikan banyak digit-digit pada d **/
    public static int getSize(long d){      
        return Long.toString(d).length();
    }
    
    /** Mengembalikan k digit pertama dari number. Jika banyak
    digitnya kurang dari k, kembalikan nilai number. **/
    public static long getPrefix(long number, int k){
        if(getSize(number)<k){
            return number;
        } else { 
            return Long.valueOf(Long.toString(number).substring(0,k));		//returns the substring that's been converted to long type
        }
    }

}