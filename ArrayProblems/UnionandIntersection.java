package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 * Question: 
 *      Given two sorted arrays, find their union and intersection.
 * Idea : 
 *      For union use mergesort's merging algo
 *      intersection is just repeating values.
 */
public class UnionandIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        union(arr1, arr2);
    }

    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        
        // Iterate through both arrays while there are elements remaining
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                // If the current elements are equal, add to the intersection list
                intersection.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                // If arr1[i] is smaller, move the pointer for arr1
                i++;
            } else {
                // If arr2[j] is smaller, move the pointer for arr2
                j++;
            }
        }
        
        return intersection;
    }

    
    public static void union(int[] arr1, int[] arr2)
    {
        //result array
        int[] res = new int[arr1.length + arr2.length];        

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i] < arr2[j])
            {
                res[k] = arr1[i];
                i++;
            }
            else if(arr2[j] < arr1[i])
            {
                res[k] = arr2[j];
                j++;
            }else if(arr1[i] == arr2[j])
            {
                res[k] = arr1[i];
                i++;
                j++;
            }

            k++; //always increases
        }

        //for remaining values
        while(i<arr1.length)
        {
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j<arr2.length)
        {
            res[k] = arr2[j];
            j++;
            k++;
        }

        System.out.print("The union is :");
        for(int s = 0; s<res.length; s++)
        {
            if(res[s] != 0)
            {
                System.out.print(res[s]+ " ");
            }
        }
        // System.out.println(Arrays.toString(res));
    }
}
