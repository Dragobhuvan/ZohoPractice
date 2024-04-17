package Strings;
/*
 * Question: 
 *  Validate whether the given string is IPV4 address or not
 * Idea: 
 *  SPlit the string by.
 *  there has to be 4 parts
 *  If a part has a length of more than 1 then leading number hshould not be 0
 *  The number has to be greater than 0 & less than 255
 *  
 */
public class ValidateIPV4 {
    public static void main(String[] args) {
        String s = "192.07.2.1";
        System.out.println(validateIp(s));
    }

    public static boolean validateIp(String s)
    {
        //if empty false
        if(s.equals(null) || s.isEmpty())
        {
            return false;
        }

        //splitting
        String[] s_arr = s.split("\\.");

        //If there are not exactly 4 parts
        if(s_arr.length!=4)
        {
            return false;
        }

        //checking each  string
        for(String str : s_arr)
        {
            //if there is a leading 0
            if(str.length()>1 && str.charAt(0) == '0')
            {
                return false;
            }

            //Parsing the string to int checking its range
           try 
           {
                int num = Integer.parseInt(str);
                if(num<0 || num>255)
                {
                    return false;
                }
           } 
           catch (NumberFormatException e) 
           {
            // TODO: handle exception

            return false;
           }

         }
        return true;
    }
}
