package ArrayProblems;
/*
 * QUestion: 
 * Given an array arr of n elements that is first strictly increasing and then maybe strictly decreasing, find the maximum element in the array.

    Note: If the array is increasing then just print the last element will be the maximum value.
    
    Input: array[]= {5, 10, 20, 15}
    Output: 20
    Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.

    Follow the below steps to Implement the idea: 

    If the first element is greater than the second or the last element is greater than the second last, print the respective element and terminate the program.
    Else traverse the array from the second index to the second last index i.e. 1 to N – 1  
    If for an element array[i] is greater than both its neighbors, i.e., array[i] > =array[i-1]  and array[i] > =array[i+1] , then print that element and terminate.
 */

public class FindPeak {
    
    public static void main(String[] args) 
    {
        int[] arr = {5,10,20,15};

        System.out.println(findPeak(arr));
        
    }

    public static int findPeak(int[] arr)
    {
        int len = arr.length-1;

        if(arr[0] > arr[1])
        {
            return arr[0];
        }

        if(arr[len] > arr[len-1])
        {
            return arr[len];
        }

        for(int i = 1; i<len; i++)
        {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
            {
                return arr[i];
            }
        }

        return -1;
    }
}
