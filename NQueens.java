public class NQueens {
	int n;
	int[][] chessBoard;
	int row = 0;
	
	
	public NQueens (int n) {
		this.n = n;
		if (n > 0) {
			chessBoard = new int[n][n];
		}
		
	}
	
	/**
	 * @param chessBoard
	 * 		nxn board of queens
	 * @param row
	 * @param col
	 *
	 * @return boolean true if safe false if not safe
	 */
	boolean attackingRange (int[][] chessBoard, int row, int col) {
		boolean result = true;
		int localRow = 0;
		int localCol = 0;
		
		localRow = 0;
		while (localRow < col) {
			if (chessBoard[row][localRow] == 1) {
				result = false;
				break;
			}
			localRow++;
		}
		if (result) {
			localRow = row;
			localCol = col;
			while (localRow >= 0 && localCol >= 0) {
				
				if (chessBoard[localRow][localCol] == 1) {
					result = false;
					break;
				}
				localRow--;
				localCol--;
			}
			if (result) {
				localRow = row;
				localCol = col;
				while (localCol >= 0 && localRow < n) {
					if (chessBoard[localRow][localCol] == 1) {
						result = false;
						break;
					}
					localRow++;
					localCol--;
				}
			}
		}
		return result;
	}
	
	/**
	 * ]
	 *
	 * @return boolean true if solution is found false if not
	 */
	public boolean placeNQueens () {
		if (n == 2 || n == 3) return false;
		if (n == 1 || n == row) return true;
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				chessBoard[x][y] = 0;
			}
		}
		if (backtrackingQueens (chessBoard, 0) == false) {
			System.out.print ("Solution does not exist");
			return false;
		}
		printToConsole ();
		return true;
	}
	
	
	public boolean backtrackingQueens (int[][] chessboard, int col) {
		if (col >= n) {
			return true;
		}
		
		int queen = 0;
		while (queen < n) {
			if (attackingRange (chessboard, queen, col)) {
				chessboard[queen][col] = 1;
				if (backtrackingQueens (chessboard, col + 1) == true) {
					return true;
				}
				chessboard[queen][col] = 0;
			}
			queen++;
		}
		return false;
	}
	
	
	public void printToConsole () {
		for (int x = 0; x < n; x++) {
			
			for (int y = 0; y < n; y++) {
				System.out.print (chessBoard[x][y]);
			}
			System.out.println ();
		}
	}
}

