public class LookNSay {
    public static void main(String[] args) {
        int n = 5;

        say(n);
    }

    public static void say(int n)
    {
        String s = "1";
        for(int i = 0; i<n; i++)
        {
            System.out.println(s);
            s = look(s);
        }
    }

    public static String look(String s)
    {
        StringBuilder res = new StringBuilder();

        int count = 0;
        char curChar = s.charAt(0);

        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == curChar)
            {
                count++;
            }else
            {
                res.append(count);
                res.append(curChar);
                curChar = s.charAt(i);
                count = 1;
            }
        }
        res.append(count);
        res.append(curChar);
        return res.toString();
    }
}
