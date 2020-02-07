import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) throws BoardFormatException, BoardFullException, BoardStateException, WinnerFoundException {
        Scanner input = new Scanner(System.in);
        
        String temp;
        char[][] papan = new char[3][3];

        for(int i = 0; i < 3; i++) {
            temp = input.nextLine();
            for(int j = 0; j < temp.length(); j++) {
                papan[i][j] = temp.charAt(j);
            }
        }
        Board board = new Board(papan);
        try{
            board.check();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}