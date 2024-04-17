package ArrayProblems;

import java.util.HashMap;

/*
 * 
 * Question: Given an array of N integers, and an integer K, the task is to find the number of pairs of integers in 
 * the array whose sum is equal to K.
 * 
 * Input: arr[] = {1, 5, 7, -1}, K = 6
    Output:  2
    Explanation: Pairs with sum 6 are (1, 5) and (7, -1).

    Input: arr[] = {1, 5, 7, -1, 5}, K = 6
    Output:  3
    Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
 */


public class CountPairs 
{
    public static void main(String[] args) 
    {
        int[] arr = {1, 5, 7, -1};
        int sum = 6;

        countV2(arr, sum);
    }

    public static void countV1(int[] arr, int sum)
    {
        int count = 0;

        for(int i = 0; i<arr.length; i++)
        {
            for(int j = i+1; j<arr.length; j++)
            {
                if(arr[i] + arr[j] == sum)
                {
                    count++;
                }
            }
        }
        System.out.println("Total count:  " + count);
    }

    public static void countV2(int[] arr, int sum)
    {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int i : map.keySet())
        {
            int complement = sum - i;

            if(map.containsKey(complement) && (i != complement || map.get(i)>1))
            {
                count = count+ map.get(complement);
            }
        }

        System.out.println(count/2);
    }
}
