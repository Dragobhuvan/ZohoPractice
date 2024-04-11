import java.util.HashMap;
import java.util.Random;
import java.util.*;

public class SnakesNLadders {

    static final int winposition = 100;

    static HashMap<Integer, Integer> snakes = new HashMap();
    static HashMap<Integer, Integer> ladders = new HashMap();

    

    public static void initialiseSnakesnLadders()
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

    static int rollDice()
    {
        int n = 0;
        Random r = new Random();

        n = r.nextInt(7);

        n = (n==0?1:n);

        return n;
    }


    static int getPosition(int playerPosition, int diceVal)
    {
        int newPos = playerPosition+diceVal;

        if(newPos == winposition)
        {
            return newPos;
        }

        if(snakes.containsKey(newPos))
        {
            System.out.println("Woops...got bit by a snake");
            newPos = snakes.get(newPos);
        }

        if(ladders.containsKey(newPos))
        {
            System.out.println("yahoooo....climbing a ladder");
            newPos = ladders.get(newPos);
        }

        return newPos;

    }

    static boolean wonGame(int position)
    {
        if(position>=winposition)
        {
            return true;
        }
        
        return false;
    }

    public static void play()
    {
        initialiseSnakesnLadders();

        System.out.println("Lets start the game, snakes & ladders await");
        int player1Position = 0;
        int player2Position = 0;

        Scanner input = new Scanner(System.in);

        int currentPlayer = -1;

        String rtoroll;

        int diceVal = 0;

        do{
         
            System.out.println(currentPlayer==-1 ? "Player 1 press r to roll the dice" : "Player 2 press r to roll teh dice");
            rtoroll = input.next();
            diceVal = rollDice();

            if(currentPlayer==-1)
            {
                player1Position = getPosition(player1Position, diceVal);
                System.out.println("The first player position: " + player1Position );
                System.out.println("The second player position: " + player2Position);   
                if(wonGame(player1Position))
                {
                    System.out.println("Congratulations...Player 1 has won the game");
                    return;
                }
            }
            else
            {
                player2Position = getPosition(player2Position, diceVal);
                System.out.println("The first player position: " + player1Position );
                System.out.println("The second player position: " + player2Position);
                if(wonGame(player1Position))
                {
                    System.out.println("Congratulations...Player 2 has won the game");
                    return;
                }
            }

            currentPlayer = -currentPlayer;

        }
        while("r".equals(rtoroll));




    }
}
