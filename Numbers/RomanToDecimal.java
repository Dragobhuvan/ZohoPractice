package Numbers;

import java.util.HashMap;

public class RomanToDecimal {
    public static void main(String args[])
    {
        String a = "IV";
        convertoDecimal(a);
    }


    static void convertoDecimal(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int preval = 0; 
        int ans = 0;

        for(int i = s.length()-1; i>=0; i--) //iteration from backwards for addition
        {
            int curval = map.get(s.charAt(i));

            if(curval>=preval)
            {
                ans += curval;
            }
            else{
                ans -= curval;
            }

            preval = curval;
        }

        System.out.print("The answer is : " + ans);
        System.out.println();
    }



}

