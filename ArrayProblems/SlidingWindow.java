package ArrayProblems;

/**
 * Question:
 * Given a sliding window of size k print the maximum of the numbers under the sliding 
    window.
    Example: Consider a sliding window of size k equals 3. Let the array be [3,2,7,6,5,1,2,3,4] the 
    output should print 7 as the first output as first window contains {3,2,7} and second window 
    contains {2,7,6} and so on and the final output is {7,7,7,6,5,3,4}
 */




import java.util.ArrayList;
import java.util.Arrays;


public class SlidingWindow 
{
    public static void main(String[] args) 
    {
        int[] arr = {3,2,7,6,5,1,2,3,4};
        int k = 3;

        slideWin(arr, k);
    }

    public static void slideWin(int[] arr, int size)
    {
        int possibleiter = arr.length-size+1; //feasible iterations over array for the size of a window, 5-3+1->3
        int[] ans = new int[possibleiter];//to store values

        for(int i = 0; i<possibleiter; i++)
        {
            int val = maxOf(Arrays.copyOfRange(arr, i, i+size));
            ans[i] = val;
        }
        System.out.println(Arrays.toString(ans));
    }

    public static int maxOf(int[] arr)
    {
        int max = Integer.MIN_VALUE;

        for(int i : arr)
        {
            if(i>max)
            {
                max = i;
            }
        }

        return max;
    }
}
