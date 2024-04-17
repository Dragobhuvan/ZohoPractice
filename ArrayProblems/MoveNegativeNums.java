package ArrayProblems;

import java.util.Arrays;

import Sorting.Swap;

public class MoveNegativeNums {
    public static void main(String[] args) {
        int[] arr = {-12,2,3,-5,-6,7};

        moveNegativeTOFront(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveNegativeTOFront(int[] arr)
    {
        int left = 0;
        int right = arr.length-1;
        while(left<=right)
        {
            while(arr[left] < 0) left++;
            while(arr[right] > 0) right--;

            if(left<=right)
            {
                Swap.swap(arr, left, right);
                left++;
                right--;
            }
        }
    }
}
