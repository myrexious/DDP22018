public class Board {

	private final int SIZE = 3;
	private char[][] papan;

	public Board(char[][] papan) {
		this.papan = papan;
	}

	public void check () throws BoardFormatException, BoardFullException, BoardStateException, WinnerFoundException{
		if(count('X')+count('O')+count('.')!=9){					//jika terdapat karakter yang tidak sesuai, throw error
			throw new BoardFormatException("Terdapat karakter selain 'O', 'X', dan '.'");
		}else if(Math.abs( (count('X') - count('O') ) ) >= 2){		//jika X dan O tidak bergantian
			throw new BoardStateException("Menyalahi aturan tic tac toe.");
		} else if(isWinnerFound()){									//jika pemenang sudah ditemukan
			throw new WinnerFoundException("Pemenang sudah ditemukan");
		} else if(count('X')+count('O') == 9){						//jika board penuh
			throw new BoardFullException("Papan tic tac toe sudah penuh.");
		}
	}

	// Optional, boleh digunakan / tidak digunakan
	// return banyaknya karakter c pada papan
	public int count(char c) {
		int ret = 0;
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				if(papan[i][j] == c) ret++;
		return ret;
	}

	// Optional, boleh digunakan / tidak digunakan
	// return true jika sudah ditemukan pemenang di papan
	public boolean isWinnerFound() {
		boolean ret = false;
		for(int i = 0; i < SIZE; i++) if(papan[i][0] != '.')
			ret |= papan[i][0] == papan[i][1] && papan[i][1] == papan[i][2];
		for(int i = 0; i < SIZE; i++) if(papan[0][i] != '.')
			ret |= papan[0][i] == papan[1][i] && papan[1][i] == papan[2][i];
		if(papan[1][1] != '.') {
			ret |= papan[1][1] == papan[0][0] && papan[1][1] == papan[2][2];
			ret |= papan[1][1] == papan[0][2] && papan[1][1] == papan[2][0];
		}
		return ret;
	}
}