package Matrix;

//https://leetcode.com/problems/game-of-life/
//in place solution
public class GameOfLife {

	public static void main(String[] args) {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				helper(board, i, j);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == -1) {
					board[i][j] = 1;
				}
				if (board[i][j] == 2) {
					board[i][j] = 0;
				}
			}
		}

	}

	private static void helper(int[][] board, int i, int j) {

		int res = 0;
		int curr = board[i][j];

		for (int k = -1; k <= 1; k++) { //loop to traverse in all directions
			for (int l = -1; l <= 1; l++) {

				if (k == 0 && l == 0) { // exclude myself from calculation
					continue;
				}

				if (i + k < 0 || i + k >= board.length || j + l < 0 || j + l >= board[0].length) {
					continue;
				}

				if (board[i + k][j + l] > 0) { //trick to handle current and future
					res++;
				}
			}
		}

		if (board[i][j] == 0 && res == 3) {
			curr = -1;// //trick to handle current and future
		}
		if (board[i][j] == 1 && (res < 2 || res > 3)) {
			curr = 2; ////trick to handle current and future
		}

		board[i][j] = curr;

	}

}
