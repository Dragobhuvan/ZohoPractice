package TwoDMatrix;

import java.util.Arrays;

public class SlideWin {
    public static void main(String[] args) {
        int[] arr = {3,2,7,6,5,1,2,3,4};
        int winSize = 3;
        slidethis(arr, winSize);
    }

    static void slidethis(int[] arr, int size)
    {
        int ans[] = new int[arr.length-size+1];//A window with a size of 3 can slide in a arr of size 5 => 5-3+1 = 3 times .
        for(int i = 0; i<arr.length-size+1; i++)//Iteration only to feasible index of window
        {
            int maxVal = maxOf(Arrays.copyOfRange(arr, i, i+size));
            ans[i] = maxVal;
        }

        for(int i: ans)
        {
            System.out.print(i+",");
        }
    }

    static int maxOf(int[] arr)
    {
        int max = 0;

        for(int i = 0; i<arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    
}
