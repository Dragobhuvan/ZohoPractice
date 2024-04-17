package Numbers;

/*
 * 
 * BAse is 2 for binary, 
 * 10 for decimal
 */
public class AddBinary
{
    public static void main(String[] args)
    {
        String s1 = "111";
        String s2 = "1";

        addBinary(s1, s2);
    }


    public static void addBinary(String s1, String s2)
    {
        int i = s1.length()-1;
        int j = s2.length()-1;

        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while(i>=0 || j>=0)
        {
            int x = (i>=0)? Character.getNumericValue(s1.charAt(i)): 0;
            int y = (j>=0)? Character.getNumericValue(s2.charAt(j)): 0;

            int sum = x + y + carry;

            //to get the number that has to be added to next val
            carry = sum/2;

            //to get remainder
            sum = sum%2;

            ans.insert(0, sum);

            i--;
            j--;
        }

        if(carry>0)
        {
            ans.insert(0, carry);
        }

        System.out.println(ans.toString());

    }
}