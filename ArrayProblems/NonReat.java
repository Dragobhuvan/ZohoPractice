package ArrayProblems;

import java.util.HashMap;

/*
 * Question: 
 * Given an array of integers of size N, the task is to find the first non-repeating element in this array. 
 * 
 * Idea: 
 *  Create a hashmap, put elemtns and count as value, return the key that has a value of 0
 * 
 */
public class NonReat {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -1, 3, 3};
        
        findNr(arr);
    }

    public static void findNr(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i : arr)
        {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }

        for(int i : arr)
        {
            if(map.get(i) == 1)
            {
                System.out.println(i);
            }
        }
    }
}
