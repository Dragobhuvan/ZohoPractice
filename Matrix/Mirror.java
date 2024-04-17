package Matrix;
/*
 * Question: 
 *    Mirror horizontally and vertically
 * Idea: 
 *  for a 3x3 matrix, 
 *  SWapping (0,0) with (0,2) is Horizontal mirror
 *  swapping (0,0) with (2,0) is vertical mirror
 */
public class Mirror 
{
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, 
                       {4,5,6},
                       {7,8,9}};
        
        hmirror(arr);
        vmirror(arr);
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<arr.length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void hmirror(int[][] arr)
    {
        int n = arr.length;

        for(int i = 0; i<n; i++)
        {
            int left = 0;
            int right = n-1;

            while(left<=right)
            {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void vmirror(int[][] arr)
    {
        int n = arr.length;

        for(int i = 0; i<n; i++)
        {
            int left = 0;
            int right = n-1;

            while(left<=right)
            {
                int temp = arr[left][i];
                arr[left][i] = arr[right][i];
                arr[right][i] = temp;

                left++;
                right--;
            }
        }
    }
}
