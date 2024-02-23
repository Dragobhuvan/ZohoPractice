public class Numberpatterns
{
    public static void main(String[] args) {
        int n = 5;
        pascal_tri(n);
    }

    static void right_ang_tri(int n)
    {
        for(int i = 1; i<=n; i++)//outer loop
        {
            for(int j = 1; j<=i; j++)//inner loop
            {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    static void right_ang_tri_v1(int n)
    {
        for(int i = n; i>=1; i--)//outer loop
        {
            for(int j = n; j>=i; j--)//inner loop
            {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    static void right_ang_tri_v2(int n)
    {
        for(int i = 1; i<=n; i++)//outer loop
        {
            for(int j = 1; j<=i; j++)//inner loop
            {
                System.out.print(i+" ");
            }
            System.out.println();

        }
    }

    static void right_ang_tri_v3(int n)
    {
        for(int i = 1; i<=n; i++)//outer loop
        {
            for(int j = i; j>=1; j--)//inner loop
            {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    static void right_ang_tri_v4(int n)
    {
        
        for(int i = 1; i<=n; i++)//outer loop
        {
            int a = 1;
            for(int j = 1; j<=i; j++)//inner loop
            {
                
                System.out.print(a+" ");
                if(a==0){
                    a=1;
                }else{
                    a = 0;
                }
            }
            System.out.println();

        }
    }

    static void right_ang_tri_v5(int n)
    {
        int num = 1;
        for(int i = 1; i<=n; i++)//outer loop
        {
            int curnum = num;
            for(int j = 1; j<=i; j++)//inner loop
            {
               System.out.print(curnum+" ");
               curnum+=n-j;
            }
            num++;
            System.out.println();

        }
    }

    static void right_ang_tri_v6(int n)
    {
        int iter = 1;
        for(int i = 1; i<=n; i++)//outer loop
        {
            int num = 1;
            for(int j = 1; j<=iter; j++)//inner loop
            {
                System.out.print(num+" ");
                if(j<i)
                {
                    num++;
                }else{
                    num--;
                }
            }
            iter+=2;
            System.out.println();
        }
    }

    static void indexValue_tri(int n)
    {
        int a = 1;
        for(int i = 1; i<=n; i++)//outer loop
        {
            for(int j = 1; j<=i; j++)//inner loop
            {
                System.out.print(a+" ");
                a++;
            }
            System.out.println();
        }
    }

    static void indexValue_tri_v1(int n)
    {
        int a = indexes(n);
        for(int i = 1; i<=n; i++)//outer loop
        {
            for(int j = 1; j<=i; j++)//inner loop
            {
                System.out.print(a+" ");
                a--;
            }
            System.out.println();
        }
    }

    static int indexes(int n)
    {
        int sum = 0;
        for(int i = 1; i<=n; i++)
        {
            sum = sum +i;
        }
        return sum;
    }

    static void inverted_right_ang_tri(int n)
    {
        
        for(int i = n; i>=1; i--)
        {
            int num =n;
            for(int j = i; j>=1; j--)
            {
                System.out.print(num+" ");
                num--;
            }
            System.out.println();
        }
    }

    static void inverted_right_ang_tri_v1(int n)
    {   
        for(int i = n; i>=1; i--)
        {
            for(int j = 1; j<=i; j++)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void spiralit(int n)
    {
        int ans[][] = new int[n][n];
        int value = 1;
        int rowStart = 0, rowEnd = ans.length-1;
        int colStart = 0, colEnd = ans[0].length-1;

        while(rowStart<=rowEnd && colStart<=colEnd)
        {
            //left to right
            for(int i = colStart; i<=colEnd; i++)
            {
                ans[rowStart][i] = value++;
            }
            rowStart+=1;
            //top to bottom
            for(int i = rowStart; i<=rowEnd; i++)
            {
                ans[i][colEnd] = value++;
            }
            colEnd-=1;
            //right to left
            for(int i = colEnd; i>=colStart; i--)
            {
                ans[rowEnd][i] = value++;
            }
            rowEnd-=1;
            //bottom to top
            for(int i = rowEnd; i>=rowStart; i--)
            {
                ans[i][colStart]= value++;
            }
            colStart+=1;
        } 

        for(int i =0; i<ans.length; i++)
        {
            for(int j = 0; j<ans[i].length;j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void pascal_tri(int n)
    {
        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<n-i; j++)
            {
                System.out.print("  "); //this prints out the spaces
            }
            int num = 1; //this will be the start of every line

            for(int k = 0; k<i+1; k++)
            {
                System.out.printf("%4d", num);
                num = num * (i-k)/ (k+1);
            }
            System.out.println();
        }

    }

    static void num_pyramid(int n)
    {
        for(int i = 1; i<=n ; i++)//outer loop
        {
            for(int j = 1; j<=n-i ;j++)//space loop
            {
                System.out.print(" ");
            }

            for(int k = 1; k<=i*2-1; k++)
            {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    static void num_pyramid_v1(int n)
    {
        for(int i = 1; i<=n ; i++)//outer loop
        {
            for(int j = 1; j<=n-i ;j++)//space loop
            {
                System.out.print(" ");
            }

            int num = i;
            for(int k = 1; k<=i*2-1; k++)
            {
                System.out.print(num);
                if(k<i)
                {
                    num--;
                }else
                {
                    num++;
                }
            }
            System.out.println();
        }
    }

    static void inverted_pyramid(int n)
    {
        for(int i = n; i>=1 ; i--)//outer loop
        {
            for(int j = 1; j<=n-i ;j++)//space loop
            {
                System.out.print(" ");
            }

            for(int k = 1; k<=i*2-1; k++)
            {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    static void timepeice(int n)
    {
        int spaces = 0;
        int prints = 2*n-1;
        for(int i = n*2-1; i>=1; i--)//outer loop
        {
            for(int j = 1; j<=spaces ;j++)//space loop
            {
                System.out.print(" ");
            }

            for(int k = 1; k<=prints; k++)
            {
                System.out.print(k);
            }

            if(i>n){
                spaces++;
                prints-=2;
            }else{
                spaces--;
                prints+=2;
            }
            System.out.println();
        }
    }

    static void timepeice_v1(int n)
    {
        int spaces = 0;
        int prints = n;
        for(int i = n*2-1; i>=1; i--)//outer loop
        {
            for(int j = 1; j<=spaces ;j++)//space loop
            {
                System.out.print(" ");
            }

            for(int k = 1; k<=prints; k++)
            {
                System.out.print(k+" ");
            }

            if(i>n){
                spaces++;
                prints--;
            }else{
                spaces--;
                prints++;
            }
            System.out.println();
        }
    }

    static void timepeice_v2(int n)
    {
        int spaces = 0;
        int prints = 1;
        for(int i = n*2-1; i>=1; i--)//outer loop
        {
            for(int j = 1; j<=spaces ;j++)//space loop
            {
                System.out.print(" ");
            }

            for(int k = prints; k<=n; k++)
            {
                System.out.print(k+" ");
            }

            if(i>n){
                spaces++;
                prints++;
            }else{
                spaces--;
                prints--;
            }
            System.out.println();
        }
    }






}