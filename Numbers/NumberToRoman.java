package Numbers;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberToRoman {
    public static void main(String args[])
    {
        int num = 84;
        convertoRoman(num);
    }

    static void convertoRoman(int num)
    {
        Map<Integer, String> romanMappings = new LinkedHashMap<>();
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
        for( int i : romanMappings.keySet())
        {
            while(num>=i)
            {
                num = num - i;
                ans.append(romanMappings.get(i));
            }
        }

        System.out.println( ans.toString());
    }
}

