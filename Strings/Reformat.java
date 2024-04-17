package Strings;

/*
 * Question: 
 *  Given a string S that consists of only alphanumeric characters and dashes. The string is separated into N + 1 groups by N dashes. Also given an integer K.

    We want to reformat the string S, such that each group contains exactly K characters, except for the first group, which could be shorter than K but still must contain at least one character. Furthermore, a dash must be inserted between two groups, and you should convert all lowercase letters to uppercase.

    Return the reformatted string.

    Idea: 
        Very simple, normal string manipulation
        
 */
public class Reformat {
    public static void main(String[] args) {
        String s = "2-5g-3-J";
        int k = 2;

        reformat(s,k);

    }

    public static void reformat(String s, int k)
    {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray())
        {
            if(c!='-')
            {
                sb.append(c);
            }
        }

        StringBuilder ans = new StringBuilder();

        int count = 0;

        for(int i = 0; i<sb.toString().length(); i++)
        {
            if(count != 0 && count%k == 0)
            {
                ans.append("-");  
            }

            ans.append(sb.charAt(i));
            count++;
        }

        System.out.println(ans.toString());
    }
}
