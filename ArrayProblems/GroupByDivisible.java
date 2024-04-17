/*
 * Question:
 * To find the number of groups and output the groups:
    Explanation: To find the sum of the elements in the groups and that sum should be divisible by 
    input X and the groups should be limited to range with X numbers.
    If X is 3, then the group should have only 2 elements and 3 elements from the array whose sum is 
    divisible by 3.
    Input:
    Array: 3, 9, 7, 4, 6, 8
    X: 3
    Output:
    3, 9
    3, 6
    9, 6
    3, 9, 6
    No of groups: 4
 */

package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class GroupByDivisible 
{
    public static void main(String[] args)
    {
        int[] arr = {3, 9, 7, 4, 6, 8};
        int num = 3;

        groupIt(arr, num);
    }

    public static void groupIt(int[] arr, int num)
    {
        // List<Integer> updatedlst = new ArrayList();

        int count = 0;
        for(int i : arr)
        {
            if(i%num == 0)
            {
                // updatedlst.add(i);
                count++;
            }
        }

        calc(count);
    }

    public static void calc(int count)
    {
        int groups = 0;
        for(int i = 2; i<=count; i++)
        {
            groups = groups + calculateCombinations(count, i);
        }
        System.out.println(groups);
    }


    /*
     * C(n,k)= n! / k! * (n-k)!
     */
    public static int calculateCombinations(int n, int k) {
        // Check for invalid input
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("Invalid input: k must be between 0 and n");
        }

        // Calculate factorial of n
        int factorialN = calculateFactorial(n);

        // Calculate factorial of k
        int factorialK = calculateFactorial(k);

        // Calculate factorial of n - k
        int factorialNK = calculateFactorial(n - k);

        // Calculate combinations using the formula
        int combinations = factorialN / (factorialK * factorialNK);

        return combinations;
    }

    public static int calculateFactorial(int num) {
        // Base case: factorial of 0 is 1
        if (num == 0) {
            return 1;
        }

        // Calculate factorial using iterative approach
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
