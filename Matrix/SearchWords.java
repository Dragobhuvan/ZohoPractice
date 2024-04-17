package Matrix;

import java.util.HashSet;
import java.util.Set;

/*
 * Question: 
 *  Given a matrix search for words
 * Idea: 
 *  nested for loop for a horizontal
 *  Nested for loop(3) for vertical
 *  Algorithm:
 *  For Horizontal keep j until reachble element, create a new string using string(char[], starting point, length)
 *  check if its in the dict.
 *  For vertical, i, j, k
 *  Keep i until reachble element(length-length of the word), initiate k = i, then create a sb and add arr[k][j]
 * 
 */
public class SearchWords 
{
    public static void main(String[] args) 
    {
        char[][] arr= {
            {'a','z','o','l'},
            {'n','o','h','o'},
            {'v','h','i','v'},
            {'o','o','s','e'}
        };
        Set<String> dictionary = new HashSet<>();
        //  {van, zoho, love, are, is}
        dictionary.add("van");
        dictionary.add("zoho");
        dictionary.add("love");
        dictionary.add("are");
        dictionary.add("is");
        dictionary.add("ho");

        for(String s : dictionary)
        {
            searchword(arr, s);
        }

    }

    public static void searchword(char[][] arr, String s)
    {
        //For hortizontal search
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j<=arr.length-s.length(); j++)
            {
                String ans = new String(arr[i], j, s.length());
                if(ans.equals(s))
                {
                    System.out.println("THw word found horizontally: " + s);
                }
            }
        }

        //for vertical
        for(int i = 0; i<=arr.length-s.length(); i++)
        {
            for(int j = 0; j<arr[i].length; j++)
            {
                StringBuilder ans = new StringBuilder();

                for(int k = i; k<=i+s.length()-1; k++)
                {
                    ans.append(arr[k][j]);
                }

                if(ans.toString().equals(s))
                {
                    System.out.println("The word found on vertical: " + s);
                }
            }
        }
    }
}
