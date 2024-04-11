import java.util.*;


public class Test {
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toar game");

        char[][] board = new char[3][3];

        char player = 'X';

        Scanner input = new Scanner(System.in);

        boolean gameOver = false;

        initialiseBoard(board);

        while(!gameOver)
        {
            
            System.out.print("Player " + player + " Enter row : ");
            int row = input.nextInt();
            System.out.print("Player " + player + " Enter column : ");
            int col = input.nextInt();
            
            if(board[row][col] == ' ' && row<board.length && col<board.length && row>=0 && col >=0)
            {
                board[row][col] = player; //placing the value
                
                if(playerHasWon(board, player,row,col))
                {
                    gameOver = true;
                }
                else
                {
                    printBoard(board);
                    player = (player=='X'? 'O': 'X');
                }
            }
            else
            {
                System.out.println("Invalid move, try again");
            }
        }
    }

    public static void initialiseBoard(char[][] board)
    {
        for(int i = 0; i <board.length; i++)
        {
            for(int j = 0; j< board[0].length; j++)
            {
                board[i][j] = ' ';
            }
        }

    }

    public static void printBoard(char[][] board)
    {
        for(int i = 0; i <board.length; i++)
        {
            for(int j = 0; j< board[0].length; j++)
            {
                System.out.print(board[i][j]+ " | ");
            }

            System.out.println();
        }
    }

    public static boolean playerHasWon(char[][] board, char player, int row, int col)
    {
        //for rows
    
        if(board[row][0] == player && board[row][1] == player && board[row][2] == player)
        {
            printBoard(board);
            System.out.println("Player " + player + " has won!");
            return true;
        }

        //cols
        if(board[0][col] == player && board[1][col] == player && board[1][col] == player )
        {
            printBoard(board);
            System.out.println("Player " + player + " has won!");
            return true;
        }

        //diagonals
        if(board[0][2] == player && board[1][1] == player && board[2][1] == player)
        {
            printBoard(board);
            System.out.println("Player " + player + " has won!");
            return true;
        }

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
        {
            printBoard(board);
            System.out.println("Player " + player + " has won!");
            return true;
        }

        
        return false;
    }
}
