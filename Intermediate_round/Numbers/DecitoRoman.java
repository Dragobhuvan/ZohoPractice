import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Question: 
 *   Given a number convert it to roman
 * Idea :
 *  Store romans with corresponding values in a linkedhashmap by numbers as keys and romans as values
 *  When the given number exceeds a key in map, append the value to sb
 *  and subract the number with the corresponding number
 */

public class DecitoRoman 
{
    public static void main(String[] args) 
    {
        int n = 11;
        convertoRoman(52);

    }

    public static void convertoRoman(int n)
    {
        Map<Integer, String> romanMappings = new LinkedHashMap();
        romanMappings.put(1000, "M");
        romanMappings.put(900, "CM");
        romanMappings.put(500, "D");
        romanMappings.put(400, "CD");
        romanMappings.put(100, "C");
        romanMappings.put(90, "XC");
        romanMappings.put(50, "L");
        romanMappings.put(40, "XL");
        romanMappings.put(10, "X");
        romanMappings.put(9, "IX");
        romanMappings.put(5, "V");
        romanMappings.put(4, "IV");
        romanMappings.put(1, "I");

        StringBuilder ans = new StringBuilder();
        for(int i : romanMappings.keySet())
        {
            while(n>=i)
            {
                ans.append(romanMappings.get(i));
                n = n-i;
            }
        }

        System.out.println(ans.toString());

    }
}
