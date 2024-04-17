public class StupidPattern {
   public static void main(String[] args) {
    int n = 5;
    stupidthis(n);
   } 

   public static void stupidthis(int n)
   {
    for(int i = 1; i<=n; i++)
    {
        int num = i;
        for(int j = 1; j<=i; j++)
        {
            System.out.print(num+" ");
            num = num +(n-j);
        }
        System.out.println();
    }
   }
}
