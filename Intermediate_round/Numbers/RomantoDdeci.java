import java.util.HashMap;

/*
 * Question:
 *      Given a roman convert it to decimal
 * Idea: 
 *      Store romasn as keys and numbers as values
 *      Create three pointer,  for result, currentvalue, previousvalue 
 *      from the end, get the corresponding value of the char in the given roman string literal
 *      if the curval is greater than preval then result gets appended to currentval
 *      else if curval is less than preval, i.e 4 ->iv in roman, where as V indicates 5
 *      so we have to subract,  result gets subracted by currentvalue.
 */


public class RomantoDdeci 
{
    public static void main(String[] args)
    {
        String rmn = "IV";

        covert(rmn);
    }

    public static void covert(String s)
    {
        HashMap<Character ,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('X',10);
        romanMap.put('V',5);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int res = 0;
        int curval = 0; 
        int preval = 0;
        for(int i = s.length()-1; i>=0; i--)
        {
            curval = romanMap.get(s.charAt(i));
            if(curval>=preval)
            {
                res = res+curval;
            }else if (curval<preval)
            {
                res = res - curval;
            }
            preval = curval;
        }

        System.out.println(res);
    }
}
