import java.util.InputMismatchException;
import java.util.Scanner;

public class Arithmetic_Operation {
    private int num1, num2;

    public void getdata() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the value of Num 1: ");
            num1 = sc.nextInt();
            System.out.print("Enter the value of Num 2: ");
            num2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch Exception is Handled!\nRe-enter the Numbers. ");
            getdata();
        }
    }
    public void division(){
        int num3 = num1 / num2;
        System.out.println(num1+"/"+num2+"= "+ num3);
    }

}




