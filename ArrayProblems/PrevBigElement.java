package ArrayProblems;

public class PrevBigElement {
    public static void main(String[] args) {
        int[] arr = { 2, -3, -4, 5, 9, 7, 8};

        find(arr);
    }

    public static void find(int[] arr)
    {
        for(int i = 0; i<arr.length-1; i++)
        {
            if(arr[i+1]>arr[i])
            {
                System.out.print(arr[i]);
            }
        }
    }
}
