package Sorting;

public class Swap {
    public static void main(String[] args) 
    {
        System.out.println("This is the file for swapper");
        int[] arr = {1,2,3};
        int first = 0;
        int second = 3;

        swap(arr, first, second);
    }

    public static void swap(int[] arr, int first, int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
