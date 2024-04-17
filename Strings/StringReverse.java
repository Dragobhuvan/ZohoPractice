/*
 * Question: 
 * . Using Recursion reverse the string such as 
        Eg 1: Input: one two three
        Output: three two one
        Eg 2: Input: I love india
        Output: india love I
 */

package Strings;

public class StringReverse 
{
    public static void main(String[] args)
    {
        String s = "one two three";
        // naiveRev(s);
        // recRevWord( s, 0);
        StringBuilder sb = new StringBuilder();
        recrevSB(s, 0, sb);
        System.out.println(sb);
    }

    public static void recrev(String s, int index)
    {
        //base condition
        if(index == s.length())
        {
            return;
        }

        recrev(s, index+1);
        System.out.print(s.charAt(index));
    }

    public static void naiveRev(String s)
    {
        for(int i = s.length()-1; i>=0; i--)
        {
            System.out.print(s.charAt(i));
        }
    }

    public static void recRevWord(String s, int index)
    {
        if(index==s.length())
        {
            return;
        }

        recRevWord(s, index+1);
        System.out.print(s.charAt(index));
    }

    public static void recrevSB(String s, int index, StringBuilder sb)
    {
        //base condition
        if(index == s.length())
        {
            return;
        }

        recrev(s, index+1);
        sb.append(s.charAt(index));
    }

   
}
