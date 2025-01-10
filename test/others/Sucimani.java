package test;

public class Sucimani {
    /*
        You are given a string s. You can convert s to a 
        palindrome
        by adding characters in front of it.

        Return the shortest palindrome you can find by performing this transformation.

        Input: s = "aacecaaa"
        Output: "aaacecaaa"
        Example 2:
        
        Input: s = "abcd"
        Output: "dcbabcd"
        
        abcd

and= "dcb"
        ab -> bab
        abcd

        start=0
        end= lenght-1
mid = old.lenght + remStr.lenght

        remStr = d + c + b
        
        abcd
          dcba

        
        Constraints:
        
        0 <= s.length <= 5 * 104
        s consists of lowercase English letters only.

 */



    public static String shortestPalindrome(String str) {

        String reversedStr = new StringBuilder(str).reverse().toString();
        String combinedStr = str + "#" + reversedStr;

        int n = combinedStr.length();
        int[] prefixArray = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && combinedStr.charAt(i) != combinedStr.charAt(j)) {
                j = prefixArray[j - 1];
            }
            if (combinedStr.charAt(i) == combinedStr.charAt(j)) {
                j++;
            }
            prefixArray[i] = j;
        }

        String prefixToAdd = new StringBuilder(str.substring(prefixArray[n - 1])).reverse().toString();
        return prefixToAdd + str;
    }

    public static void main(String[] args) {
        String input1 = "ab";
        System.out.println("Shortest Palindrome: " + shortestPalindrome(input1));

        String input2 = "abcd";
        System.out.println("Shortest Palindrome: " + shortestPalindrome(input2));
    }
}


