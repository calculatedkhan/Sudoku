public class Main {
    public static void main(String[] args) {
        GenerateBoard board = new GenerateBoard();
        Board sudokuBoard = new Board(board.createBoard());
        board.printBoard();
        Solver solver = new Solver(sudokuBoard);
        solver.solve();
    }
}
