/*
 * Use constructor for common values
 * 
 * DO NOT REFER THIS FILE IN FUTURE, NO CONSTRUCTR IS USED SO HAD TO CREATE A INTSZ OUT OF THIN AIR
 * DO NOT REFER THIS IN FUTURE
 */


import java.util.Random;
import java.util.Scanner;

public class MineSweepEngine
{

    static final char UNEXPLORED = '-';
    static final char EXPLORED = ' ';
    static final char MINE = '*';

    static int sz = 5;

    static char[][] board = new char[5][5];
    static boolean[][] mines = new boolean[5][5];

    public static void play(int size, int mineCount)
    {
        intitaliseBoard(size);

        placeMines(mineCount, size);

        Scanner input = new Scanner(System.in);

        while(true)
        {
            printBoard(false);
            System.out.print("Enter row: ");
            int row = input.nextInt();
            System.out.println();
            System.out.print("Enter col: ");
            int col = input.nextInt();
            System.out.println();
            reveal(row, col);
        }
    }

    public static void intitaliseBoard(int size) 
    {
        for(int i = 0 ; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                board[i][j] = UNEXPLORED;
            }
        }
    }

    public static void placeMines(int mineCount, int size)
    {
        mines = new boolean[size][size];

        Random r = new Random();

        int count = 0;

        while(count<=mineCount)
        {
            int row = r.nextInt(size);
            int col = r.nextInt(size);

            if(!mines[row][col])
            {
                mines[row][col] = true;
                count++;
            }
        }
    }

    public static void printBoard(boolean showMines)
    {   
        //to print UI
        System.out.print("  ");
        for(int i = 0; i<sz; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i<sz ; i++)
        {
            System.out.print("- ");
        }
        System.out.println();

        //fucntion
        for(int i = 0; i<sz; i++)
        {
            System.out.print( i + "|");
            for(int j = 0; j<sz; j++)
            {
                if(board[i][j] == UNEXPLORED && !showMines)
                {
                    System.out.print(UNEXPLORED + " ");
                }else if(mines[i][j] =  true)
                {
                    System.out.print(MINE + " ");
                }else
                {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void reveal(int row, int col)
    {
        if(row<0 || row>sz || col<0 || col>sz)
        {
            return;
        }

        if(board[row][col] != UNEXPLORED)
        {
            return;
        }

        if(mines[row][col] = true)
        {
            printBoard(true);
            System.out.println("You touched a mine");
            System.exit(0);
        }

        int adjacentmines = 0;

        for(int i = row-1; i<row+1; i++)
        {
            for(int j = col-1; j<col+1; j++)
            {
                if(i>=0 && j>=0 && i<sz && j<sz && mines[i][j])
                {
                    adjacentmines++;
                }
            }
        }

        board[row][col] = (char)(adjacentmines + '0');

        if(adjacentmines == 0)
        {
            for(int i = row-1 ; i<row+1; i++)
            {
                for(int j = col-1; j<col+1; j++)
                {
                    reveal(i, j);
                }
            }
        }
    }
}
