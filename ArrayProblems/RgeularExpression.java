package ArrayProblems;
/*
 * Enter two strings from command line and check whether any substring present in first 
    string that follows the pattern of second sting..
 */
public class RgeularExpression {
    
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "a*cd";
        boolean result = isPatternMatched(str1, str2);
        System.out.println(result ? "Yes" : "No");
    }

    public static boolean isPatternMatched(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();
        
        // Check for empty pattern string
        if (m == 0) return n == 0;
        
        int i = 0, j = 0;
        // int match = 0, starIdx = -1;
        
        while (i < n) {
            // If characters match or pattern character is '\'
            if (j < m && (str1.charAt(i) == str2.charAt(j) || str2.charAt(j) == '\\')) {
                i++;
                j++;
            }
            // If pattern character is '*'
            else if (j < m && str2.charAt(j) == '*') {
                // starIdx = j;
                // match = i;
                i++;
                j++;
            }
            // If characters do not match, and pattern character is not '*'
            // else if (starIdx != -1) {
            //     j = starIdx + 1;
            //     // match++;
            //     // i = match;
            // }
            // If no '*' was encountered yet, and characters do not match
            else {
                return false;
            }
        }
        
        // Check remaining characters in pattern
        while (j < m && str2.charAt(j) == '*') {
            j++;
        }
        
        return j == m;
    }
    
}
