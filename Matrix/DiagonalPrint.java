package Matrix;

public class DiagonalPrint {
    public static void main(String[] args) {
        int arr[][] = { 
            { 1, 2, 3, 4 },      
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 },   
            { 13, 14, 15, 16 }, 
            { 17, 18, 19, 20 }, 
        };

        printMatrix(arr);
    }

        public static void printMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m + n - 1; i++) {
                 int start_row = i < m ? i : m - 1;
                 int start_col = i < m ? 0 : i - m + 1;
                 while (start_row >= 0 && start_col < n) {
                       System.out.print(matrix[start_row--][start_col++] + " ");
                 }
                 System.out.println("\n");
             }
        }
}
