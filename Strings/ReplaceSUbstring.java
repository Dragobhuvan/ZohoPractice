package Strings;

public class ReplaceSUbstring {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String s1 = "eek";
        String s2 = "ok";

        replace(s,s1,s2);
    }

    static void replace(String s, String s1, String s2)
    {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) != s1.charAt(0))
            {
               ans.append(s.charAt(i));
            }
            else if(s.charAt(i) == s1.charAt(0))
            {
                boolean found = true;
                for(int k = i+1, n=1; k<k+s1.length() && n<s1.length();k++, n++)
                {
                    if(s.charAt(k)!=s1.charAt(n))
                    {
                        found = false;
                    }
                }

                if(found)
                {
                    ans.append(s2);
                    if(i<s.length()-s2.length())
                    {
                        i=i+s2.length();
                    }
                    
                }
            }
        }

        System.out.println(ans.toString());
    }
}
