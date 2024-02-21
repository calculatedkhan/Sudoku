import java.util.Arrays;
import java.util.Random;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerateBoard {
    int[][] board = new int[9][9];

    public int[][] createBoard() {
        Random random = new Random();
        Set<Integer> usedNumbers = new HashSet<>();

        // Top-left subgrid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = random.nextInt(9) + 1;
                } while (usedNumbers.contains(num));
                board[i][j] = num;
                usedNumbers.add(num);
            }
        }

        // Middle subgrid
        usedNumbers.clear(); // Clear the set to reuse it
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                int num;
                do {
                    num = random.nextInt(9) + 1;
                } while (usedNumbers.contains(num));
                board[i][j] = num;
                usedNumbers.add(num);
            }
        }

        // Bottom-right subgrid
        usedNumbers.clear(); // Clear the set to reuse it
        for (int i = 6; i < board.length; i++) {
            for (int j = 6; j < board.length; j++) {
                int num;
                do {
                    num = random.nextInt(9) + 1;
                } while (usedNumbers.contains(num));
                board[i][j] = num;
                usedNumbers.add(num);
            }
        }
        return board;
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
