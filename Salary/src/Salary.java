import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select your Designation!!!");
            System.out.println("1. Professor");
            System.out.println("2. Associate Professor");
            System.out.println("3. Assistant Professor");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    Professor p=new Professor();
                    p.getdata();
                    p.display();
                    break;
                case 2:
                    Associate_Professor aop=new Associate_Professor();
                    aop.getdata();
                    aop.display();
                    break;
                case 3:
                    Assistant_Professor asp=new Assistant_Professor();
                    asp.getdata();
                    asp.display();
                    break;
                case 4:
                    choice=4;
                    break;
                default:
                    System.out.println("Invalid Input!!!!!!!!");
                    break;
            }
        }while (choice!=4);
    }
}
