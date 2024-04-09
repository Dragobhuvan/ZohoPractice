/*
 * Question: 
 * 
 * Given a string S consisting of N, lower case English alphabet, it is also given that a string is encrypted by first 
 * replacing every substring of the string consisting of the same character with the concatenation of that character and 
 * the hexadecimal representation of the size of the substring and then revering the whole string, the task is to find the 
 * encrypted string. 

    Note: All Hexadecimal letters should be converted to Lowercase letters.

    Examples:
    Input: S = “aaaaaaaaaaa”
    Output: ba 

    Explanation : 
    First convert the given string to “a11” i.e. write, character along with its frequency.
    Then, change “a11” to “ab” because 11 is b in hexadecimal.
    Then, finally reverse the string i.e “ba”.

    Input: S = “abc”
    Output: 1c1b1a
 */


import java.util.HashMap;
import java.util.LinkedHashMap;

public class EncryptingStr
{
    public static void main(String[] args)
    {
        String s = "abc";
        encrypt(s); 
    }


    public static void encrypt(String s)
    {
        HashMap<Character, Integer> cmap = new LinkedHashMap<>();//to store the char and its weight
        StringBuilder ans = new StringBuilder();//to store chars and its weight
        for( char c : s.toCharArray())
        {
            cmap.putIfAbsent(c, 0);
            cmap.put(c, cmap.get(c)+1);
        }

        for(char c : cmap.keySet())
        {
            ans.append(c);
            ans.append(cmap.get(c));
        }

        // System.out.println(ans.toString());

        String s2 = ans.toString();//a11b2

        StringBuilder sb2 = new StringBuilder();//to store decimal that has to converted to hex
        StringBuilder finalans = new StringBuilder();//to store finals ans

        for(int i = 0; i<s2.length(); i++)
        {
            if(Character.isAlphabetic(s2.charAt(i)))//checks if its alphabetic
            {
                if(sb2.length() > 0)
                {
                    finalans.append(hexThis(Integer.parseInt(sb2.toString())).toLowerCase());//Converting the number to a hex val and appending it to finalsans
                    sb2.setLength(0);//to cancel out prev stored numbers
                }

                finalans.append(s2.charAt(i));//adds the char to final answer
            }

            if(!Character.isAlphabetic(s2.charAt(i)))//for the numbers
            {
                sb2.append(s2.charAt(i));//stored
            }
        }
        if(sb2.length()>0)//there will be a last number remaining 
        {
            finalans.append(hexThis(Integer.parseInt(sb2.toString())).toLowerCase());
        }

        // System.out.println(finalans);

        reverse(finalans.toString());//to reverse
    }

    public static String hexThis(int n)
    {
        if(n == 0)
        {
            return "0";
        }

        char[] hexDigits = "0123456789ABCDEF".toCharArray();

        StringBuilder hexval = new StringBuilder();

        while(n>0)
        {
            int remainder = n%16;

            hexval.insert(0, hexDigits[remainder]);

            n = n/16;
        }
        return hexval.toString();
    }

    public static void reverse(String s)
    {
        for(int i = s.length()-1; i>=0; i--)
        {
            System.out.print(s.charAt(i));
        }
    }
}