package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramCheck {
    public static void main(String[] args) 
    {
        String[] arr = {"tea", "ate", "bat", "tan", "tab"};

        groupAnag(arr);
    }

    public static void groupAnag(String[] arr)
    {
        HashMap<String, List<String>> sortedMap = new HashMap();

        for(String s : arr)
        {
            char[] carr = s.toCharArray();

            qckSrt(carr, 0, carr.length-1);
            // Arrays.sort(carr);

            
            String sortedString = new String(carr);            

            if(!sortedMap.containsKey(sortedString))
            {
                sortedMap.put(sortedString, new ArrayList<>());
            }

            sortedMap.get(sortedString).add(s);
        }

        System.out.println(sortedMap.values());
        
    }

    public static void qckSrt(char[] c, int low, int high)
    {
        int start = low;
        int end = high;
        int midIdx = start + (end-start)/2;
        char pivot = c[midIdx];

        //base condition
        if(low>=high)
        {
            return;
        }

        while(start<=end)
        {
            while(c[start] < pivot)
            {
                start++;
            }

            while(c[end] > pivot)
            {
                end--;
            }

            if(start<=end)
            {
                //swap function
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;

                start++;
                end--;
            }
        }

        qckSrt(c, start, high);
        qckSrt(c, low, end);
    }


}
