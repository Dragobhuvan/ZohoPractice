/*
 * Question: 
 * Check if two given Strings are Isomorphic to each other
    Two strings str1 and str2 are called isomorphic if there is a one-to-one mapping possible for every character of str1 to every character of str2. And all occurrences of every character in ‘str1’ map to the same character in ‘str2’.

    Examples: 

    Input:  str1 = “aab”, str2 = “xxy”
    Output: True
    Explanation: ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’.

    Input:  str1 = “aab”, str2 = “xyz”
    Output: False
    Explanation: One occurrence of ‘a’ in str1 has ‘x’ in str2 and other occurrence of ‘a’ has ‘y’.
 */

package Strings;

import java.util.HashMap;

public class Isomorphic {
    public static void main(String[] args) {
        String s1 = "vvvbhhh";
        String s2 = "xxxbyyy";

        if(ismorph(s1, s2))
        {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static boolean ismorph(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            return false;
        }

        HashMap<Character, Character> cmap = new HashMap<>();
        for(int i = 0; i<s1.length(); i++)
        {
            cmap.putIfAbsent(s1.charAt(i), s2.charAt(i));

            if(s2.charAt(i) != cmap.get(s1.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }
}
