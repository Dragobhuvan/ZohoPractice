package Matrix;

/*
 * Question: 
 *      Rotate
 * Idea : 
 *      Transpose the matrix first, then swapp opposite elements in a column for clockwise and 
 *      swap opp.ele. in rows for anti clockwise
 * Algorithm: 
 *      To transpose :      
 *          nested loop where j = i, then do swapping btw elements by [i][j] = [j][i]
 *      To Rotate: 
 *          Clockwise :  (i.e) Horizontal mirror
 *          Create two pointers, left, right 
 *          Iterate over rows [i][left] and swap with [i][right]
 *          Anti-clockwise: (i.e) Vertical mirror
 *          Iterate over each column [left][i] and swap with [right][i]
 */

public class MatrixRotate 
{
    public static void main(String[] args) 
    {
        int[][] arr = {{1,2,3}, 
                       {4,5,6},
                       {7,8,9}};

        rotate(arr);

        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<arr.length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][]arr)
    {
        transpose(arr);
        rotateanticlockwise(arr);
    }

    public static void transpose(int [][] arr)
    {
        int n = arr.length;
        for(int i = 0; i<n; i++)
        {
            for(int j = i; j<n; j++) // on i = 0 :  j =0(no swap), j=1(swap btw (0,1) & (1,0))
                                    // on i = 1 : Already placed (1,0) is automatically skipped
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void rotateclockwise(int[][] arr)
    {
        int n = arr.length;

        for(int i =0; i<n; i++)
        {
            int left = 0; 
            int right = n-1;

            while(left<=right)//swap till left equals to right
            {
                int temp = arr[i][left];        // We want to swap (0,1) with (0,2)
                arr[i][left] = arr[i][right];
                arr[i][right] =  temp;
                left++;
                right--;
            }
        }
    }

    public static void rotateanticlockwise(int[][] arr)
    {
        int n = arr.length;

        for(int i =0; i<n; i++)
        {
            int left = 0; 
            int right = n-1;

            while(left<=right)//swap till left equals to right
            {
                int temp = arr[left][i]; // we want to swap (0,1) with (2,0)
                arr[left][i] = arr[right][i];
                arr[right][i] = temp;
                left++;
                right--;
            }

        }
    }
}
