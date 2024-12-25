package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InformaticaTest {
    

    void printHello(){
        System.out.println("Hello to you..");
    }


/*
    Next grestest from arry of integer.
        
        [4,2,4,5,15,10,9,25]
        {
            index
            nextGraterValuesIndex
        }

        {0, 1}
        {1, -1}
    print

    -1
 * 




I am good

Good am i
I ma doog
doog ma I

 */

    void reverseString(String input) {
        System.out.println("Reverse: "+reverseStr(input));
        String[] splitString = input.split(" ");
        StringBuilder oone = new StringBuilder();
        for(int i = splitString.length-1; i>=0; i--) {
            oone.append(splitString[i]);           
            if(' ' != oone.charAt(oone.length()-1) ) {
                oone.append(" ");
            } 
        }
        System.out.println("Word reverse: "+oone.toString());
        oone = new StringBuilder();

        for(int i = 0; i < splitString.length; i++) {
            oone.append(reverseStr(splitString[i]));     
            if(' ' != oone.charAt(oone.length()-1) ) {
                oone.append(" ");
            }    
            
        }
        System.out.println("Split reverse: "+oone.toString());
    }
"abc"

StringBuilder

    private String reverseStr(String string) {
        char[] ichar = string.toCharArray();
        StringBuilder oone = new StringBuilder();
        for(int i = ichar.length-1; i>=0; i--) {
            
            if(ichar[i] == ' '){
                if(' ' != oone.charAt(oone.length()-1) ) {
                    oone.append(" ");
                } 
            }
            else {
                oone.append(ichar[i]);
            }
        }
        return oone.toString();
    }


    public static void main(String[] args) {
    
        InformaticaTest test = new InformaticaTest();

        test.reverseString("I    am go  od");

    }
}
