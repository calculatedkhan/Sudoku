import java.util.Random;

class Square {
    private int[][] numbers;

    public Square() {
        numbers = new int[3][3];
    }

    public void fillWithRandomNumbers(Random random) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[i][j] = random.nextInt(9) + 1; // Random number between 1 and 9
            }
        }
    }

    public int getNumber(int row, int column) {
        return numbers[row][column];
    }
}