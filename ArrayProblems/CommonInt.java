package ArrayProblems;
/*
 * Question: 
 *  Find common elements in three sorted arrays
    Given three Sorted arrays in non-decreasing order, print all common elements in these arrays. 
   Idea:
    Three pointers
    if not the same, then increase the pointer where smallest int is present
    As it is sorted, things will work out
 */
public class CommonInt {
    public static void main(String[] args) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        findCommon(ar1, ar2, ar3);
    }

    public static void findCommon(int[] ar1, int[] ar2, int[] ar3)
    {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < ar1.length && j<ar2.length && k<ar3.length)
        {
            if(ar1[i] == ar2[j] && ar2[j] == ar3[k])
            {
                System.out.print(ar1[i] + " ");
                i++;
                j++;
                k++;
            }else if (ar1[i] < ar2[j])
            {
                i++;
            }else if (ar2[j] < ar3[k])
            {
                j++;
            }else
            {
                k++;
            }
        }
    }
}
