package Numbers;

public class Prime
{
  public static void main(String[] args) {
    int n = 8;
    findprimes(n);
  }  

  public static void findprimes(int n)
  {
    for(int i = 1; i<=n; i++)
    {
        int count = 0;
        for(int j = 1; j<=i; j++)
        {
            if(i%j == 0)
            {
                count++;
            }
        }
        if(count<=2)
            {
                System.out.print(i + " ");
            }
    }
  }
}
