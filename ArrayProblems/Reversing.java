package ArrayProblems;

import java.util.Arrays;

public class Reversing {
    public static void main(String[] args) {
        int[] arr = {5,4,3,1};

        recrev(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseV1(int[]arr)
    {
        int left = 0; 
        int right = arr.length-1;

        while(left<=right)
        {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int[] arr, int first, int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void recrev(int[] arr, int start, int end)
    {
        //base condition
        if(start>=end)
        {
            return;
        }

        swap(arr, start, end);

        recrev(arr, start+1, end-1);
    }
}
