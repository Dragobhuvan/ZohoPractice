public class DiagonalPrint {
    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
            { 17, 18, 19, 20 }
        };

        printit(matrix);
    }

    public static void printit(int[][]arr)
    {
        int m = arr.length;
        int n = arr[0].length;

        for(int i = 0; i<m; i++)
        {
            int row = Math.min(i, m-1);
            int col = Math.max(0, i-m+1);

            while(row>=0 && col<n)
            {
                System.out.print(arr[row][col] +" ");
                row--;
                col++;
            }
            System.out.println();
        }
    }
}
