/*
 * QUestion: 
 *  GIven an array sort the odd values in ascending and even in descending
 * 
 * Algorithm: 
 *      Nested for loop for odd and even sperately
 *      for odd start i =0 and go i+=2;
 *      for even start i = 1;
 */
package Sorting;

import java.util.Arrays;

public class OddEvenSort 
{
    public static void main(String[] args) 
    {
        int[] arr = {6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr)
    {
        //odd
        for(int i = 0; i<arr.length; i+=2)
        {
            for(int j = i+2; j<arr.length; j+=2)
            {
                if(arr[i]<arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //for even
        for(int i = 1; i<arr.length; i+=2)
        {
            for(int j = i+2; j<arr.length; j+=2)
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
