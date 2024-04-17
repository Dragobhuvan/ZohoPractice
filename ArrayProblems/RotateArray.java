package ArrayProblems;

import java.util.Arrays;

/*
 * Question: 
 *  Given an array, the task is to cyclically rotate the array clockwise by one time. 
 * 
 * Idea: 
 *      Store the last elemetn
 *      then assign the element value as the previous element value, at last elemtn reiject stored element
 *  
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotate(arr);
    }

    public static void rotate(int[] arr)
    {
        int len = arr.length;
        int val = arr[len-1];
        for(int i = len-1; i>=0; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[0] = val;

        System.out.println(Arrays.toString(arr));
    }
}
