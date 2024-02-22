import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Solver {

    Board board;

    public Solver(Board board) {
        this.board = board;
    }
    private boolean isPossible(int currentRow, int currentCol, int numberToCheck) {
        return !checkRow(currentRow, numberToCheck) && !checkCol(currentCol, numberToCheck) && !checkSquare(currentRow, currentCol, numberToCheck);
    }

    private boolean checkRow(int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board.getValue(row, col) == num) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board.getValue(row, col) == num) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSquare(int currentRow, int currentCol, int numberToCheck) {
        int squareStartRow = (currentRow/3)*3;
        int squareStartCol = (currentCol/3)*3;
        for (int rowOffset = 0; rowOffset < 3; rowOffset++) {
            for (int colOffset = 0; colOffset < 3; colOffset++) {
                if (board.getValue(squareStartRow + rowOffset, squareStartCol + colOffset) == numberToCheck) {
                    return true;
                }
            }
        }
        return false;
    }

    public void returnBoard() {
        board.printBoard();
    }
    public void solveBoard() {
        if (solveBoardWithThreadPool()) {
            System.out.println("The board has at least 1 solution");
        } else {
            System.out.println("The Board has no solutions.");
        }
    }

//    private boolean solveBoardWithThreadPool() {
//        ExecutorService executor = Executors.newFixedThreadPool(9);
//
//        try {
//            return solveCell(0, 0, executor);
//        } finally {
//            executor.shutdown();
//        }
//    }

    private boolean solveBoardWithThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try {
            List<Callable<Boolean>> tasks = new ArrayList<>();
            tasks.add(() -> solveCell(0, 0, executor));
            List<Future<Boolean>> results = executor.invokeAll(tasks);

            // Check if all tasks have completed successfully
            for (Future<Boolean> result : results) {
                if (!result.get()) {
                    return false;
                }
            }
            return true;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        } finally {
            executor.shutdown();
        }
    }

    private boolean solveCell(int row, int col, ExecutorService executor) {
        if (row == 9) {
            return true; // Puzzle solved
        }

        if (col == 9) {
            return solveCell(row + 1, 0, executor); // Move to next row
        }

        if (board.getValue(row, col) != 0) {
            return solveCell(row, col + 1, executor); // Cell already filled, move to next column
        }

        for (int i = 1; i <= 9; i++) {
            if (isPossible(row, col, i)) {
                board.setValue(row, col, i);

                if (solveCell(row, col + 1, executor)) {
                    return true;
                }

                board.setValue(row, col, 0); // Backtrack
            }
        }

        return false; // No valid number found for this cell
    }
}