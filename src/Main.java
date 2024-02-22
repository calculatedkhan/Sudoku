public class Main {
    public static void main(String[] args) {
       // GenerateBoard boardGenerator = new GenerateBoard();
//        int[][] initialBoard = boardGenerator.createBoard();
//        Board sudokuBoard = new Board(initialBoard);
//        Solver solver = new Solver(sudokuBoard);
//        solver.solveBoard();
//        solver.returnBoard();

        long totalTime = 0; // Variable to accumulate total time

        // Run the algorithm 50 times
        for (int i = 0; i < 1; i++) {
            GenerateBoard boardGenerator = new GenerateBoard();
            int[][] initialBoard = boardGenerator.createBoard();
            Board sudokuBoard = new Board(initialBoard);

            // Start measuring time
            long startTime = System.nanoTime();

            Solver solver = new Solver(sudokuBoard);
            //solver.returnBoard();
            solver.solveBoard();
            solver.returnBoard();


            // End measuring time
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            totalTime += duration;
        }

        // Calculate average time
        double averageTime = totalTime / 50.0; // Divide by the number of iterations

        // Print the average time
        System.out.println("Average time taken by the solver over 50 runs: " + averageTime + " nanoseconds");
    }
}
