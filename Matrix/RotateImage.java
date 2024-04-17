package Matrix;
/*
 * 
 * Question : 
 * Rotate the picture
 * 
 * Simple formule for arr[i][j] = res[j][n-i-1]
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        rotatePicture(mat);
    }

    public static void rotate(int[][] arr)
    {
        int n = arr.length;//3
        int m = arr[0].length;//4

        int[][] res = new int[m][n];

        int row =0;
        int col = 0;
        for(int i = n-1; i>=0 ; i--)
        {
            col = n - (i+1);
            for(int j = 0; j<m; j++)
            {
                row = j;
                res[row][col] = arr[i][j];
            }
        }

        for(int i = 0; i<res.length; i++)
        {
            for(int j = 0; j<res[0].length; j++)
            {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotatePicture(int[][] portrait) {
        int rows = portrait.length;
        int cols = portrait[0].length;

        int[][] landscape = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                landscape[j][i] = portrait[i][j];
            }
        }

        for(int i = 0; i<landscape.length; i++)
        {
            for(int j = 0; i<landscape[0].length; j++)
            {
                System.out.print(landscape[i][j]);
            }
            System.out.println();
        }
    }
}
