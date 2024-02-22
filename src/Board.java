import java.util.ArrayList;
import java.util.Random;

class Board {

//    static int[][] board = {
//            {1, 0, 0, 0, 2, 0, 3, 0, 4},
//            {0, 4, 0, 5, 6, 0, 7, 8, 0},
//            {0, 9, 0, 0, 8, 0, 0, 0, 2},
//            {0, 0, 3, 0, 0, 8, 0, 0, 7},
//            {0, 0, 7, 0, 0, 0, 6, 0, 0},
//            {8, 0, 0, 2, 0, 0, 9, 0, 0},
//            {6, 0, 0, 0, 1, 0, 0, 3, 0},
//            {0, 5, 8, 0, 9, 3, 0, 7, 0},
//            {2, 0, 1, 0, 4, 0, 0, 0, 6}
//    };


    int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }

    public int getValue(int row, int col) {
        return board[row][col];
    }

    public void setValue(int row, int col, int val) {
        board[row][col] = val;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+-------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
