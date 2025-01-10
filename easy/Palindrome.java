package easy;

public class Palindrome {

    boolean isPalindrome(long number) {
        /*  
            Reverse the input and match
            1. find remainder and append in the result in result
            2. number = number/10 
        */
        return number == reverse(number)? true:false;
    }
    

    long reverse( long number) {
        long result = 0;
        while(number != 0) {
            long n = number%10;
            result = result*10+n;
            number = number / 10;
        }
        return result;
    }

    long findNearestPalindrome(long number) {
        long result=0;
        long gnumber=number, snumber = number;

        while (snumber != 0) { 
            snumber--;
            gnumber++;
            if(isPalindrome(snumber)) {
                return snumber;
            }else if(isPalindrome(gnumber)) {
                return gnumber;
            }
            
        }
        return result;
    }

    String findNearestPalindrome(String number) {
        long longnumber = Long.parseLong(number);
        long result=0;
        long gnumber=longnumber, snumber = longnumber;

        while (snumber != 0) { 
            snumber--;
            gnumber++;
            // if(isPalindrome(snumber)) {
            //     return snumber+"";
            // }else if(isPalindrome(gnumber)) {
            //     return gnumber+"";
            // }

            if(isPalindrome(gnumber)) {
                return gnumber+"";
            }
            
        }
        return result+"";
    }

    boolean recursivePalindrome(String input, int start, int end) {
        if(start >= end) {
            return true;
        }
        if(input.charAt(start) != input.charAt(end)) {
            return false;
        }
        return recursivePalindrome(input, start+1, end-1);
    }


    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();

        System.err.println("Result  - "+palindrome.isPalindrome(1211));
        System.out.println("Nearest palindrome: "+palindrome.findNearestPalindrome(123));
        System.out.println("Nearest palindrome: "+palindrome.findNearestPalindrome("123"));
        String input = "1111222211111";
        System.out.println("Nearest palindrome: "+palindrome.recursivePalindrome(input ,0 ,input.length()-1));
    }
}
