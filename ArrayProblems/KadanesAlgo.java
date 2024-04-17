 /*
    Given array find maximum sum of contiguous sub array
    {-2 -3 4 -1 -2 1 5 -3}
    output 7 elements [ 4 -1 -2 1 5]

    Note : Only if the sum becomes 0, next set of large sub array starts.

 */

    

package ArrayProblems;

public class KadanesAlgo {
    public static void main(String[] args) 
    {
        int[] arr = {4,-1,-2,1,5};

        largestSubarr(arr);
    }

    public static void largestSubarr(int[] arr)
    {
        int max_end = 0;
        int max_so_far=Integer.MIN_VALUE;
        int start = 0; 
        int end = 0;

        for(int i = 0; i<arr.length; i++)
        {
            max_end = max_end+arr[i];

            if(max_end>max_so_far)
            {
                max_so_far = max_end;//updated sum 
                end = i;
            }

            if(max_end<0)
            {
                max_end = 0;
                start = i+1;//this will store the element where sum is reset and new value is started
            }
        }
         
        System.out.println(max_so_far);
        for(int i = start; i<=end; i++)
        {
            System.out.print(arr[i] + " ");
        }


    }
}
