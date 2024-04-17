package ArrayProblems;

import java.util.Arrays;

import Sorting.Swap;

/*
 * Question: 
    Given an array having positive and negative numbers, our task is to arrange them in an alternate fashion 
    such that every positive number is followed by a negative number and vice-versa maintaining the order of appearance. 
    The number of positive and negative numbers need not to be equal. 
    *  If there are more positive numbers then they have to appear at the end of the array , same condition for negative numbers also .
    Examples: 
        Input:  arr[] = {1, 2, 3, -4, -1, 4}
        Output: arr[] = {-4, 1, -1, 2, 3, 4}
 */
public class ReArrangeNegPos {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,5};

        reArrange(arr);
    }

    public static void reArrange(int[] arr)
    {


        for(int i = 0; i<arr.length; i+=2)
        {
            int neg = i;
            int pos = i;
            while(neg<arr.length-1 && arr[neg]>0)
            {
                neg++;
            }
            while(pos<arr.length-1 && arr[pos]<0)
            {
                pos++;
            }

            if(arr[i+1]<0)
            {
                Swap.swap(arr, pos, i+1);
            }

            if(arr[i] > 0)
            {
                Swap.swap(arr, neg, i);
            } 
            
               
        }

        System.out.println(Arrays.toString(arr));
    }
    
    
    
}
