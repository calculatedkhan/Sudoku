import java.util.Random;
import java.util.ArrayList;

class Square {
    private int[][] numbers;

    public Square() {
        numbers = new int[3][3];
    }

    public void fillWithRandomNumbers(Random random) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int randomIndex = random.nextInt(nums.size());
                numbers[i][j] = 1;
            }
        }
    }

    public int getNumber(int row, int column) {
        return numbers[row][column];
    }
}
