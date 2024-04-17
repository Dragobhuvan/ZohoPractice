package Strings;

public class Subsof012 {
    public static void main(String[] args) {
        String s = "0102010";

        findCount(s);
    }

    static void findCount(String s)
    {
        int count = 0;

        int[] countArr = new int[3];

        for(int i =0; i<s.length()-3; i++)
        {
            countArr[0] = 0;
            countArr[1] = 0;
            countArr[2] = 0;

            for(int j = i; j<i+3; j++)
            {
                countArr[s.charAt(j) - '0']++;
            

            if(countArr[0] == countArr[1] && countArr[1] == countArr[2])
            {
                count++;
            }
        }
        }

        System.out.println(count);
    }
}
