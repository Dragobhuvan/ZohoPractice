/*
 * Design a tic tac toe
 * 
 * Has a char board of 3x3, 
 * Switch players X or O
 * 
 * 
 */

import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args)
    {
        char[][] board = new char[3][3];

        char player = 'X';

        initialiseboard(board);

        boolean gameover = false;

        Scanner input = new Scanner(System.in);

        while(!gameover)
        {
            System.out.println("Player " + player + " select row: ");
            int row = input.nextInt();

            System.out.println("Player " + player + " select row: ");
            int col = input.nextInt();

            //Checking for index out of bounds and if its empty
            if(row>=0 && row<3 && col>=0 && col<3 && board[row][col] == ' ')
            {
                board[row][col] = player;
                if(gameWon(board, player, row, col))
                {
                    System.out.println("Player" + player + " has won the game");
                    gameover = true;
                }else
                {
                    printBoard(board);
                    player = (player=='X')? 'O': 'X';
                }

            }
            else
            {
                System.out.println("Invalid move, already filled");
                System.out.println("Retrying");
            }

        }
    }


    public static void initialiseboard(char[][] board)
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    public static boolean gameWon(char[][] board, char player, int row, int col)
    {
        //checking for cols
        if(board[row][0] == player && board[row][1] == player && board[row][2] == player)
        {
            return true;
        }
        //for cols
        if(board[0][col] == player && board[1][col]==player && board[2][col] == player)
        {
            return true;
        }

        //for diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
        {
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
        {
            return true;
        }

        return false;
    }

    public static void printBoard(char[][]board)
    {
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[i].length; j++)
            {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}