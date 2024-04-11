/*
 * Question: 
 *  Given a number convert it to alphabet
 *  1 = A, 27 = AB, 1000 = ALL
 * Idea : 
 *   26 letters in Alphabet, so the given number is made to (n-1)so that we have(0-25)-> 26,
 *   then find the remainder of the number by %26, typecase and add it to 'A', insert it into a Stringbuilder at 0th position.
 *   As teh remainder is already calculated, the number is divided by 26(/26).
 * 
 */
import java.util.Scanner;

public class NumbertoAlphabet {
    public static void main(String[] args) {
        int number =52;
        toAlphabet(number);
    }

    public static void toAlphabet(int n)
    {
        StringBuilder ans = new StringBuilder();

        while(n>0)
        {
            int remainder = (n-1)%26;

            char leter = (char)('A' + remainder);

            ans.insert(0, leter);

            n = (n-1)/26;
        }

        System.out.println(ans.toString());
    }
}