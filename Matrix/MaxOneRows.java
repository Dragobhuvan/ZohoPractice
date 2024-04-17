package Matrix;

public class MaxOneRows {
    public static void main(String[] args) {
        int mat[][] = { {0, 0, 0, 1},
                    {0, 1, 1, 1},
                    {1, 1, 1, 1},
                    {0, 0, 0, 0}};
        findRow(mat);
    }

    public static void findRow(int[][] arr)
    {
        int max = Integer.MIN_VALUE;
        int row = 0;

        for(int i = 0; i<arr.length; i++)
        {
            int count = countOf(arr[i]);
            if(count>max)
            {
                max = count;
                row = i;
            }
        }

        System.out.println(row);
    }

    public static int countOf(int[] row)
    {
        int count = 0;

        for(int i = 0; i<row.length; i++)
        {
            if(row[i] == 1)
            {
                count++;
            }
            
        }
        return count;
    }
}
