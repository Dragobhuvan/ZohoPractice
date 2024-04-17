package ArrayProblems;
/*
 * QUestion: 
 *  Given an array arr[] of size n containing 0 and 1 only. The problem is to count the subarrays having an equal number of 0’s and 1’s.
Examples:  
Input: arr[] = {1, 0, 0, 1, 0, 1, 1}
Output: 8
Explanation: The index range for the 8 sub-arrays are: (0, 1), (2, 3),  (3, 4), (4, 5),(2, 5), (1, 6)

IDea : 
    Make all the 0's as -1
    create a map, then a var count = 0;
    Then travserse the array, calculating the sum...when the sum becomes 0, it means ther is a pair(1,-1)
    so count is 1, 
    also put the sum and its frequqncy im map..
    When a sum != 0 appears.... check the map for previous apperance..then add the value of it to the count
    (i.e) when -1 appears....then from 0 idx to ith idx, there are equal pairs of 0,1 soo when a -1sum appears(0)
    it can be paired with previous two 1's.
 */

import java.util.HashMap;
import java.util.Map;

public class SubArrayZerosNOnes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1};
        findCount(arr);
    }

    public static void findCount(int[] arr)
    {
        Map<Integer, Integer> fqmap = new HashMap();
        
        int count = 0;

        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i] == 0)
            {
                arr[i] = -1;
            }
        }
         
        int sum = 0;
        for(int i = 0; i<arr.length; i++)
        {
            sum +=arr[i];

            if(sum==0)
            {
                count++;
            }

            if(fqmap.containsKey(sum))
            {
                count+= fqmap.get(sum);
            }else{
                fqmap.putIfAbsent(sum, 0);
                fqmap.put(sum, fqmap.get(sum)+1);
            }            
        }

        System.out.println(count);
    }
}
