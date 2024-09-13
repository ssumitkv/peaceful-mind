import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello world!!");

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("input: "+a);
        scan.close();
    }
}