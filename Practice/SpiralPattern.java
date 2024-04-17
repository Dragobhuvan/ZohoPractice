public class SpiralPattern
{
    public static void main(String[] args)
    {
        int i = 5;

        spiral(i);
    }

    public static void spiral(int n)
    {
        int[][] arr = new int[n][n];

        int row_Start = 0;
        int row_End = n-1;
        int col_Start = 0;
        int col_End = n-1;

        int count = 1;

        while(row_Start<=row_End && col_Start<=col_End)
        {
            //from left to right
            for(int i = col_Start; i<=col_End; i++)
            {
                arr[row_Start][i] = count;
                count++;
            }
            row_Start++;

            //from top to bottom
            for(int i = row_Start; i<=row_End;i++)
            {
                arr[i][col_End] = count;
                count++;
            }
            col_End--;

            //right to left
            for(int i = col_End; i>=col_Start; i--)
            {
                arr[row_End][i] = count;
                count++;
            }
            row_End--;

            //bottom to top
            for(int i = row_End; i>=row_Start; i--)
            {
                arr[i][col_Start] = count;
                count++;
            }
            col_Start++;
        }


        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<arr.length; j++)
            {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }
}