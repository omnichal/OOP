import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        choice();
        int ch1;
        do {
            System.out.println("Do you want to Continue:");
            System.out.println("1.Yes");
            System.out.println("2.Exit");
            Scanner sc = new Scanner(System.in);
            ch1 = sc.nextInt();

            if (ch1 == 1) {
                choice();
            }
        } while (ch1 == 1);
    }

    public static void choice(){
        Shape ref;
        int ch;
        System.out.println("Choose the Shape: ");
        System.out.println("1.Circle");
        System.out.println("2.Triangle");
        System.out.println("3.Rectangle");
        System.out.println("4.Exit");
        Scanner sc=new Scanner(System.in);
        ch=sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("Circle");
                ref=new Circle();
                ref.getdata();
                ref.compute_area();
                break;
            case 2:
                System.out.println("Triangle");
                ref=new Triangle();
                ref.getdata();
                ref.compute_area();
                break;
            case 3:
                System.out.println("Rectangle");
                ref=new Rectangle();
                ref.getdata();
                ref.compute_area();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }
}
