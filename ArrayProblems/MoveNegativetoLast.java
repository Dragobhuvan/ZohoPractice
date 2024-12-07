package Arrays;

public class MoveNegativetoLast {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        segregateElements(arr);

        for(int i : arr)
        {
            System.out.print(i+" ");
        }
    }

  

    public static void segregateElements(int[] arr) {
        // Your code goes here
        for(int i = 0; i<arr.length-1; i++)
        {
                for(int j = i; j<arr.length;j++)
            {
                int x = j;
                int y = j+1;
                    while(arr[j]<0 && arr[j+1] >0 && x<arr.length-1 && y<arr.length-1)
                    {
                        swap(arr,x,y);
                        x++;
                        y++;
                    }
            }
        }
        
    }
    
    public static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
