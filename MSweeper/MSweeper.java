import java.util.Scanner;

public class MSweeper
{
    public static void main(String[] args) 
    {
        int size = 5;
        int mines = 6;

        MSengine game = new MSengine(size, mines);

        game.play();
    }
}