package ArrayProblems;

/*
 * Question: 
 *     Given an array arr[] of non-negative integers and an integer sum, find a subarray that adds to a given sum.
       Note: There may be more than one subarray with sum as the given sum, print first such subarray. 
    Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
    Output: Sum found between indexes 2 and 4
    Explanation: Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33    
 */


public class SubArraySum {
    public static void main(String[] args) 
    {
        int[] arr = {1,4,20,3,10,5};

        int sum =33;

        findSubs(arr, sum);
    }

    public static void findSubs(int[] arr, int sum)
    {
        int start = 0;

        for(int i = 0; i<arr.length; i++)
        {
            start = i;

            int val = arr[i];

            while(val<=sum && i<arr.length-1)
            {
                val = val + arr[i+1];

                if(val == sum)
                {
                    System.out.println(start + " " +(int) (i+1));
                }
                
                i++;
            }

            i = start;
        }

    }
}
