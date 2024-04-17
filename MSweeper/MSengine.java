import java.util.Random;
import java.util.Scanner;

public class MSengine {

    private int size;
    private int minecount;
    private int unexploredNonmineCells;

    
    private final char UNEXPLORED = '-';
    private final char EXPLORED = ' ';
    private final char MINE = '*';
    
    private char[][] board;
    private boolean[][] mines;

    public MSengine(int Size, int Mines) {
        this.size = Size;
        this.minecount = Mines;
        board = new char[size][size];
        mines = new boolean[size][size];
        initialiseBoard();
        placeMines();
        unexploredNonmineCells = size*size -minecount;
    }

    public void play()
    {
        Scanner input = new Scanner(System.in);
        while (true) {
            printBoard(false);
            System.out.print("Enter row and column to explore (e.g., 0 0): ");
            int row = input.nextInt();
            int col = input.nextInt();
            reveal(row, col);

            if (unexploredNonmineCells == 0) {
                System.out.println("Congratulations! You won!");
                break;
            }
        }
        input.close();

    }

    private void reveal(int row, int col)
    {
        //base condition
        if(row<0 || col<0 || row>=size | col>=size)
        {
            return;
        }

        //Already explored
        if(board[row][col] != UNEXPLORED)
        {
            return;
        }

        //WHen hit a mine
        if(mines[row][col])
        {
            printBoard(true);
            System.out.println("You've hit a mine");
            System.exit(0);
        }

        int adjacentminescount = 0;

        for(int i = row-1; i<row+1 ; i++)
        {
            for(int j = col-1; j<col+1; j++)
            {
                if(i>=0 && i<size && j>=0 && j<size && mines[i][j])
                {
                    adjacentminescount++;
                }
            }
        }

        // board[row][col] = (adjacentminescount == 0) ? EXPLORED : (char) (adjacentminescount + '0');
        board[row][col] = (char)(adjacentminescount+'0');
        if(adjacentminescount == 0)
        {
            board[row][col] = EXPLORED;
        for(int i = row-1; i<row+1 ; i++)
        {
            for(int j = col-1; j<col+1; j++)
            {
                if(i>0 && i<size && j>0 && j<size)
                {
                    reveal(i, j);
                }
            }
        }
        }

        unexploredNonmineCells--;

    }

    private void printBoard(boolean revealmines) 
    {
        System.out.print("   ");
        for(int i = 0; i<size; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i<size; i++)
        {
            System.out.print(i+ " |");
            for(int j = 0; j<size; j++)
            {
                if(board[i][j] == UNEXPLORED && !revealmines)
                {
                    System.out.print(UNEXPLORED+" ");
                }else if(mines[i][j])
                {
                    System.out.print(MINE+" ");
                }else
                {
                    System.out.print(board[i][j] +" ");
                }
            }
            System.out.println();
        }

    }

    private void initialiseBoard()
    {
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++ )
            {
                board[i][j] = UNEXPLORED;
            }
        }
    }

    private void placeMines()
    {
        Random r = new Random();
        int count = 0;

        while(count<minecount)
        {
            int row = r.nextInt(size);
            int col = r.nextInt(size);

            mines[row][col] = true;
            count++;
        }
    }

}

    
