package ArrayProblems;

/*
 * Question: 
 *  Find duplicates in O(n) time and O(1) extra space | Set 1
    Given an array of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of times.
    Find these repeating numbers in O(n) and use only constant memory space.
    Note: The repeating element should be printed only once.\
    IIdea: 
        Flaggin the index of the number that is alrready visited
 */
public class FindDupes {
   public static void main(String[] args) 
   {
        int[] arr = {1,2,4,5,1,3};
        findDupe(arr);
   } 

   public static void findDupe(int[] arr)
   {
    for(int i = 0; i<arr.length; i++)
    {
        int idx = Math.abs(arr[i]);

        if(arr[idx]<0)
        {
            System.out.print(idx);
        }else
        {
            arr[idx] = -arr[idx];
        }
    }
   }
}
