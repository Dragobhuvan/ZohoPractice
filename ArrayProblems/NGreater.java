package ArrayProblems;



public class NGreater {
    
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "a*c";
        boolean result = isPatternMatched(str1, str2);
        System.out.println(result ? "Yes" : "No");
    }

    static boolean isPatternMatched(String str1, String str2) {
        int firstIdx = 0;
        int secondIdx = 0;

        while (secondIdx < str2.length()) {
            char currChar = str2.charAt(secondIdx);

            if (currChar == '\\') {
                // Skip the backslash and compare the next character
                secondIdx++;
                if (secondIdx >= str2.length() || str1.charAt(firstIdx) != str2.charAt(secondIdx)) {
                    return false;
                }
            } else if (currChar == '*' && str1.charAt(firstIdx) != '*' ) {
                // Check for zero or more occurrences
                int ival = secondIdx-1;
                while (firstIdx < str1.length() && str1.charAt(firstIdx-1) == str2.charAt((ival)))
                {  
                    firstIdx++;
                }
                secondIdx++;
            } else {
                // Compare characters
                if (firstIdx >= str1.length() || str1.charAt(firstIdx) != currChar) {
                    return false;
                }
                firstIdx++;
                secondIdx++;
            }
        }

        // Ensure both strings have been matched completely
        return firstIdx == str1.length() && secondIdx == str2.length();
    }
}
