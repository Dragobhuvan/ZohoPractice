/*
 * Question
 * Find if a String2 is substring of String1. If it is, return the index of the first occurrence. else 
   return -1. 
    Eg 1:Input:
    String 1: test123string
    String 2: 123
    Output: 4
    Eg 2: Input:
    String 1: testing12
    String 2: 1234 
    Output: -1
 */

package Strings;

import java.util.Arrays;

public class Substring
{
    public static void main(String[] args) {
        
        String s = "Bhuvan123";
        String p = "123";

        // System.out.println(Arrays.toString(findRangeSub(s, p)));
        System.out.println(FindSub(s, p));
    }

    public static int FindSub(String s, String p)
    {
        for(int i = 0; i<=s.length()-p.length(); i++)//traversing the sentence
        {
            if(s.charAt(i) == p.charAt(0))//when first char matches
            {
                boolean found = true;

                //checking for matches of all characters in pattern
                for(int j = 1; j<p.length(); j++)//First char is already checked, so skipping it
                {
                    if(s.charAt(i+j) != p.charAt(j))
                    {
                        found = false;
                        break;
                    }
                }
                if(found)
                {
                    return i;
                }
            }
        }

        return -1;

    }

    public static int[] findRangeSub(String s, String p)
    {
        int[] ans = new int[2];
        for(int i = 0; i<s.length(); i++)//traversing the sentence
        {
            if(s.charAt(i) == p.charAt(0))//when first char matches
            {
                boolean found = true;

                //checking for matches of all characters in pattern
                for(int j = 1; j<p.length(); j++)//First char is already checked, so skipping it
                {
                    if(s.charAt(i+j) != p.charAt(j))
                    {
                        found = false;
                    }
                }
                if(found)
                {
                    ans[0] = i;
                    ans[1] = i+p.length()-1;
                    return ans;
                }
            }
        }

        ans[0]  = -1;
        ans[1] = -1;
        return ans;

    }

    //This method can check if the target is present at the text if some of target chars can be removed.
    public static boolean isSubsequence(String text, String target)
    {
        int i = 0; 
        int j = 0;

        for(; i<text.length() && j<target.length(); j++)
        {
            if(text.charAt(i) == target.charAt(j))
            {
                i++;
            }
        }

        return i == text.length();
    }
}