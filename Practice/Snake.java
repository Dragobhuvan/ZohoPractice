public class Snake {
    public static void main(String[] args) {
        int n = 5;

        snakeV1(n);
    }

    public static void snake(int n)
    {
        int count = 1;

        for(int i = 1; i<=n; i++)
        {
            if(i%2!=0)
            {
                for(int j = 0; j<i; j++)
                {
                    System.out.print(count);
                    count++;
                }
            }
            else
            {
                int dupecount = count+i-1;
                for(int j = 0; j<i; j++)
                {
                    System.out.print(dupecount);
                    dupecount--;
                    count++;
                }
            }

            System.out.println();
        }
    }

    public static void snakeV1(int n)
    {
        int count = 1;

        for(int i = 0; i<n; i++)
        {
            if(i%2 == 0)
            {
                for(int j = 0; j<n; j++)
                {
                    System.out.print(count+" ");
                    count++;
                }
            }else
            {
                int dupe = count + n -1;
                for(int j = 0; j<n; j++)
                {
                    System.out.print(dupe+" ");
                    dupe--;
                    count++;
                }
            }
            System.out.println();
        }
        
    }
}
