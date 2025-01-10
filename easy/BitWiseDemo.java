package easy;




import java.util.Scanner;

public class BitWiseDemo {
    
    public static void main(String[] args) {
        System.out.println("Binary value of 102 is:  "+ Integer.toBinaryString(100));

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        String binary = convertToBinary(input);
        System.out.println("Banary of "+input+" is: "+binary);
        int equivalantDecimal = convertBinaryToDecimal(binary);
        System.out.println("Decimal value of: "+binary+", is: "+equivalantDecimal);



        scan.close();
    }

    private static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        int power = 1;
        for(int i = binary.length()-1; i >=0; i--) {
            if(binary.charAt(i) == '1'){

                decimal = decimal + power;
            }
            power = power*2;
        }
        return decimal;
    }

    private static String convertToBinary(int input) {
        String binary = "";
        while(input >= 1) {
            binary += (input%2);
            input = input/2;
        }
        return  reverse(binary);
    }

    public static String reverse(String input)
    { 
        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = input.getBytes();
 
        byte[] result = new byte[strAsByteArray.length];
 
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
 
        return new String(result);
    }

}
