import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static final int SIZE = 5;
    private static final int MINES = 5;
    private static final char UNEXPLORED = '-';
    private static final char MINE = '*';
    private static final char EXPLORED = ' ';

    private char[][] board;
    private boolean[][] mines;

    public Minesweeper() {
        board = new char[SIZE][SIZE];
        mines = new boolean[SIZE][SIZE];
        initializeBoard();
        placeMines();
        // calculateAdjacentMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = UNEXPLORED;
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int count = 0;
        while (count < MINES) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                count++;
            }
        }
    }

    // private void calculateAdjacentMines() {
    //     for (int i = 0; i < SIZE; i++) {
    //         for (int j = 0; j < SIZE; j++) {
    //             if (!mines[i][j]) {
    //                 int adjacentMines = 0;
    //                 for (int r = i - 1; r <= i + 1; r++) {
    //                     for (int c = j - 1; c <= j + 1; c++) {
    //                         if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && mines[r][c]) {
    //                             adjacentMines++;
    //                         }
    //                     }
    //                 }
    //                 board[i][j] = UNEXPLORED; // Change from (char) (adjacentMines + '0');
    //             }
    //         }
    //     }
    // }
    
    private void printBoard(boolean revealMines) {
        System.out.print("   ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == UNEXPLORED && !revealMines) {
                    System.out.print(UNEXPLORED + " ");
                } else if (mines[i][j]) {
                    System.out.print(MINE + " ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private void reveal(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return;
        }
        if (board[row][col] != UNEXPLORED) {
            return;
        }
        if (mines[row][col]) {
            printBoard(true);
            System.out.println("Game Over! You hit a mine.");
            System.exit(0);
        }
        int adjacentMines = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < SIZE && j >= 0 && j < SIZE && mines[i][j]) 
                {
                    adjacentMines++;
                }
            }
        }
        board[row][col] = (char) (adjacentMines + '0');
        if (adjacentMines == 0) {
            board[row][col] = EXPLORED;
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    reveal(i, j);
                }
            }
        }
    }
        
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard(false);
            System.out.print("Enter row and column to explore (e.g., 0 0): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            reveal(row, col);
        }
    }

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.play();
    }
}
