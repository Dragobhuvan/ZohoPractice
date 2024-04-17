import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Game 
{
    static HashMap<Integer, Integer> snakes = new HashMap();
    static HashMap<Integer, Integer> ladders = new HashMap();


    public static void play(int numPlayers)
    {
        //Initialise
        initialiseBoard();

        final int winposition = 100;

        String rtoRoll;

        int currentPlayer = 0;

        int[] playerPositions = new int[numPlayers];//to store player positions

        Scanner input = new Scanner(System.in);

        int diceVal;

        do
        {
            System.out.println("Player" + (currentPlayer+1) + "Press R to roll the dice");
            rtoRoll = input.next();
            diceVal = rolldice();

            playerPositions[currentPlayer] = getPlayerPos(playerPositions[currentPlayer], diceVal);

            printPlayerPos(playerPositions);
            if(wonGame(playerPositions[currentPlayer]))
            {
                System.out.println("Player" + (currentPlayer + 1) + "has won the game");
                return;
            }  

            currentPlayer++;
            if(currentPlayer==numPlayers)
            {
                currentPlayer =0;
            }
        }
        while(rtoRoll.equals("r"));
    }

    public static void initialiseBoard()
    {
        snakes.put(99, 2);
        snakes.put(87, 67);
        snakes.put(45, 34);
        snakes.put(17, 9);
        snakes.put(8, 1);

        ladders.put(9,19);
        ladders.put(23,89);
        ladders.put(37,98);
        ladders.put(76,83);
        ladders.put(41,99);
    }

    public static int rolldice()
    {
        int n;

        Random rnum = new Random();
        
        n = rnum.nextInt(7);

        if(n == 0)
        {
            n = 1;
        }

        return n;
        
    }

    public static int getPlayerPos(int playerpos, int diceval)
    {
        int newpos = playerpos+diceval;

        if(snakes.containsKey(newpos))
        {
            System.out.println("------------------------------");
            System.out.println("OOPS, got bitten by a snake");
            System.out.println("------------------------------");

            return snakes.get(newpos);
        }

        if(ladders.containsKey(newpos))
        {
            System.out.println("------------------------------");
            System.out.println("Yahooooo...climbing a ladder");
            System.out.println("------------------------------");  
            
            return ladders.get(newpos);
        }

        return newpos;
    }

    public static boolean wonGame(int n)
    {
        if(n >= 100)
        {
            return true;
        }

        return false;
    }

    public static void printPlayerPos(int[] playerpos)
    {
        for(int i = 0; i<playerpos.length; i++)
        {
            System.out.println("Player " + (i+1) + "'s position : " + playerpos[i]);
        }
    }


}
