import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = { 3, -1, 2, 0 };
        int low = 0;
        int high = arr.length-1;

        System.out.println(Arrays.toString(arr));
    }

    // Swap algo
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void bubble(int[] arr) {
        // By traversing the array, we check if neighbouring elemt is greater than self,
        // if yes then swap it!
        // outer loop to traverse till the length of the array
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            // to get two elements
            for (int j = 1; j < arr.length - i; j++) {
                // on each iteration max value will go the last index so we add length-i, as we
                // no need to check the last element
                if (arr[j] < arr[j - 1]) {
                    // swap
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            // the sort is finished when no swap takes place
            if (!swapped) {
                break;
            }
        }
    }

    static void selection(int[] arr) {
        // Logic : Select the max value and swap it to the crct index
        // outer loop
        for (int i = 0; i < arr.length; i++) {
            // high is the last index of the array, to avoid repititive checking of the
            // already sorted values we add -i
            int end = arr.length - 1 - i;
            // to find the index of the max value
            int maxindex = max(arr, end);
            // swap
            swap(arr, end , maxindex);
        }
    }

    // Maxindex algo
    static int max(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

// Merge sort algo
    static int[] mergeSort(int[] arr){
        //base condition
        if (arr.length == 1){
            return arr;
        }
        // mid
        int mid = arr.length/2;
        // splitting the array
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }

    static int[] merge(int[]ar1, int[]ar2){
        int[] ans = new int[ar1.length+ar2.length];
        int i =0,j=0,k=0;

        while(i<ar1.length && j<ar2.length){
            if(ar1[i]<ar2[j]){
                ans[k] = ar1[i];
                i++;
            }else{
                ans[k] = ar2[j];
                j++;
            }
            k++; //Always increase 
        }
        while(i<ar1.length){
            ans[k] = ar1[i];
            i++;
            k++;
        }
        while(j<ar2.length){
            ans[k] = ar1[j];
            j++;
            k++;
        }
        return ans;
    }

// Quick sort
static void quickSort(int[]arr, int low, int high){
    int start = low;
    int end = high;
    int mid = start + (high-start)/2;
    int pivot = arr[mid];
// base condition
    if(low>=high){
        return;
    }
    while(start<=end){
        while(arr[start]<pivot) start++;
        while(arr[end]>pivot) end--;

        if(start<=end){
            swap(arr,start,end);
            start++;
            end--; 
        }
    }
    quickSort(arr, low, end);
    quickSort(arr, start, high);
}
}
