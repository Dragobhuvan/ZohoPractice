import java.util.*;

public class MineSweeperGame {
    static int size = 5;
    static int mineCount = 5;
    static char unexplored = '-';
    static char explored = ' ';
    static char mine = '*';

    static char board[][];
    static boolean mines[][];

    public MineSweeperGame()
    {
        board = new char[size][size];

        mines = new boolean[size][size];

        initialiseBoard();
        setmines();

    }

    static void initialiseBoard()
    {
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j< size; j++)
            {
                board[i][j] = unexplored;
            }
        }
    }

    static void setmines()
    {
        int count = 0;
        Random rand = new Random();
        int row = rand.nextInt(size);
        int col = rand.nextInt(size);
        while(count<mineCount)
        {
            mines[row][col] = true;
            count++;
        }
    }
    static void printBoard(Boolean showmine)
    {
        System.out.print("   ");
        for(int i = 0; i<size ; i++)
        {
            System.out.print(i+ " ");
        }
        System.out.println();
        for(int i = 0; i<size; i++)
        {
            System.out.print(i + " |");
            for(int j = 0; j<size; j++)
            {
               if(board[i][j]==unexplored && !showmine)
               {
                System.out.print(unexplored+" ");
               } else if (mines[i][j])
               {
                System.out.print(mine + " ");
               } else 
               {
                System.out.print(board[i][j]);
               }

            }
            System.out.println();
        }

    }

    static void revealIt(int row, int col)
    {
        if(row<0 && row >=size && col<0 && col>=size)//if input exceeds row & col
        {
            return;
        }

        if(board[row][col] != unexplored) //if explored is given again
        {
            System.out.println("Already explored");
            return;
        }

        if(mines[row][col])
        {
            printBoard(true);
            System.out.println("You touched a mine");
            System.out.println("Exitting........bye");
            System.exit(0);
        }

        int adjacentMine = 0;

        for(int i = row-1; i<=row+1; i++)
        {
            for(int j = col-1; j<=col+1; j++)
            {
                if(i>=0 && i <size && j>=0 && j<size && mines[i][j])
                {
                    adjacentMine++;
                }
            }
        }

        board[row][col] = (char)(adjacentMine+'0');
        if(adjacentMine==0)
        {
            board[row][col] = explored;
            for(int i = row-1; i<=row+1; i++)
            {
                for(int j = col-1; j<=col+1; col++)
                {
                    
                    revealIt(row, col);
                
                }
            }
        }
    }


    static void play()
    {
        Scanner input = new Scanner(System.in);
        printBoard(false);
        while(true)
        {
            System.out.print("Enter the row :");
            int row  = input.nextInt();
            input.nextLine();
            System.out.print(" Enter the column: ");
            int col = input.nextInt();
            revealIt(row, col);
        }
    }
    public static void main(String[] args) {
        MineSweeperGame game = new MineSweeperGame();
        game.play();
    }
}
