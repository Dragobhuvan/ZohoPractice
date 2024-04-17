package Strings;
/*
 * Question: 
 *  Recreate Integer.parseInt
 *  Idea: 
 *      Create result var, and sign var to keep track of the sign
 *      if char is btw 0 & 9, 
 *      res = res*10 + (char-'0')
 */
public class Atoi {
    public static void main(String[] args) {
        String str = "12345";

        atoi(str);
    }

    public static void atoi(String s)
    {
        if(s.equals(null) || s.isEmpty())
        {
            throw new NumberFormatException("STring is empty or null");
        }

        int res = 0;
        int sign = 1;

        int i = 0;

        if(s.charAt(i) == '-')
        {
            sign = -1;
            i++;
        }
        if(s.charAt(i) == '+')
        {
            i++;
        }

        for(; i<s.length(); i++)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <='9')
            {
                res = res * 10 + (s.charAt(i) - '0');
            }
        }

        System.out.println(sign * res);

    }
}
