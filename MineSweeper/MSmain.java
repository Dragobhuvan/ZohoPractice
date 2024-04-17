public class MSmain
{
    public static void main(String[] args) 
    {
        int size = 5;
        int mines = 6;

        System.out.println("Welcome to  minesweeper");

        MineSweepEngine m = new MineSweepEngine();

        m.play(size, mines);

    }
}