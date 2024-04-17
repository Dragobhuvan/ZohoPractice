package Strings;

import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        String s = "ABC";
        permute(s.toCharArray(), 0);
    }

    public static void permute(char[] s, int idx)
    {
        //base condition
        if(idx==s.length-1)
        {
            System.out.print(Arrays.toString(s) + " ");
        }

        for(int i = idx; i<s.length; i++)
        {
            swap(s, idx, i);
            permute(s, idx+1);
            swap(s, idx, i);
        }
    }

    public static void swap(char[] s, int first, int second)
    {
        char temp = s[first];
        s[first] = s[second];
        s[second] = temp;
    }
}
