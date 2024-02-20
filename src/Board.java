import java.util.Random;

class Board {
    private Square[][] squares;

    public Board() {
        squares = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    public void fillWithRandomNumbers() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j].fillWithRandomNumbers(random);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        System.out.print(squares[i][j].getNumber(k, l) + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            if (i < 2) {
                System.out.println("------+-------+------");
            }
        }
    }
}
