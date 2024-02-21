
public class Solver {

    Board board;

    public Solver(Board board) {
        this.board = board;
    }

    public void solve() {
        if (solveBoard()) {
            System.out.println("Its been solved: ");
            board.printBoard();
        } else {
            System.out.println("No solution exists.");
        }
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

    private boolean solveBoard() {
        //For every position in the puzzle
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                //If it has no value, represented by 0
                if (board.getValue(row, col) == 0) {
                    //Check every possibility for that position, taking the first one that works
                    for (int i = 1; i <= 9; i++) {
                        //Check if its possible, against row, column and square
                        if (isPossible(row, col, i)) {
                            board.setValue(row, col, i); //set that position to the first possible number

                            if (solveBoard()) { //recursively call itself with new state
                                return true;
                            }

                            board.setValue(row, col, 0); //resets value to 0 if given state was impossible
                        }
                    }
                    return false; // if no number works returns false, and jumps back a state to previous correct state
                }
            }
        }
        return true; //once solved returns true
    }
}