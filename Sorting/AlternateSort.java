/*
 * Question:  Alternatively sort a sorted array
 */


package Sorting;

import java.util.Arrays;

public class AlternateSort {
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3,4,5};

        altSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void altSort(int[] arr)
    {

        for(int i = 0; i<arr.length; i++)
        {
            int n = arr.length-1;
            int max = arr[n];    
            while(n>i)
            {
                arr[n] = arr[n-1];
                n--;
            }
            arr[i] = max;
            i++;
        }
    }
}

