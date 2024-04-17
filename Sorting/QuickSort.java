package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,1,0,0};

        qck(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void qck(int[] arr, int low, int high)
    {
        int start = low;
        int end = high;
        int midIdx = low + (high -low)/2;
        int pivot = arr[midIdx];

        //base condition
        if(low>=high)
        {
            return;
        }

        while(start<=end)
        {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;

            if(start<=end)
            {
                Swap.swap(arr, start, end);
                start++;
                end--;
            }
        }

        qck(arr, start, high);
        qck(arr, low, end);
    }
}
