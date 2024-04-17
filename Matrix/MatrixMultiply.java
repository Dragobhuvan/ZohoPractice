package Matrix;

public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] mat1 = { { 1, 1 },
                         { 2, 2 } };

        int[][] mat2 = { { 2, 5 },
                         { 2, 2 } };

        multiply(mat1, mat2);
    }

    public static void multiply(int[][] mat1, int[][] mat2)
    {
        int[][] res = new int[mat1.length][mat2.length];

        for(int i = 0; i<res.length; i++)
        {
            for(int j = 0; j<res[0].length; j++)
            {
                res[i][j] = (mat1[i][j] * mat2[i][j]);
            }
        }


        for(int i = 0; i<res.length; i++)
        {
            for(int j = 0; j<res[0].length; j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
