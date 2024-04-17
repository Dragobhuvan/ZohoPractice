package Numbers;

public class NumberToAlphabet {
    public static void main(String[] args) {
        int n = 1000;

        convertToAlph(n);
        
        // System.out.println(1%26);
        // System.out.println((char)('A'+25));
    }

    static void convertToAlph(int n)
    {
        StringBuilder ans = new StringBuilder();

        while(n>0)
        {
            int remainder = (n-1) % 26;
            char letter = (char)('A' + remainder);
            ans.insert(0, letter);
            n = (n-1)/26;
        }

        System.out.println(ans.toString());
    }
}
