import java.util.Scanner;
public class Main {
    public static void main(String [] args) {
        Arraylist container = new Arraylist();
        runApp(container);
    }

    static Scanner sc = new Scanner(System.in);

    public static void runApp(Arraylist c) {
        int input = -1;
        int ch;
        while(input != 0) {
            System.out.println("1. Add");
            System.out.println("2. Check");
            System.out.println("3.Exit");
            System.out.print("Choice: ");
            input = sc.nextInt();
            switch(input) {
                case 1:
                    System.out.println("Add");
                    System.out.println("1.String");
                    System.out.println("2.Number");
                    ch = sc.nextInt();
                    if(ch == 1) {
                        c.add(true);
                        c.display();
                    }else {
                        c.add(false);
                        c.display();
                    }
                    break;

                case 2:
                    c.classifyEvenOdd();
                    c.classifyPrime();
                    c.checkPallindrome();
                    break;
                case 3:
                    break;
            }
        }
    }

}