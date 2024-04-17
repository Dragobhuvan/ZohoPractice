package Strings;

/*
 * Question: 
 *  Giving a dictionary and a string ‘str’, 
 *  find the longest string in dictionary which can be formed by deleting some characters of the given ‘str’. 
   Examples: 
    Input : dict = {"ale", "apple", "monkey", "plea"}   
        str = "abpcplea"  
    Output : apple 

    Idea: 
        Simple, find if the word is a subsequenc or not
        then return the one with the largest length

 */

public class FIndLargeinDIct {
    public static void main(String[] args) {
        String[] s_arr = {"ale", "apple", "monkey", "plea"};
        String str = "abpcplea";

        findLarge(s_arr, str);
        
    }

    public static void findLarge(String[] arr, String s)
    {
        String ans = "";

        for(String str : arr)
        {
            if(isSubsequence(str, s))
            {
                if(str.length() > ans.length())
                {
                    ans = str;
                }
            }
        }
        System.out.println(ans);
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
