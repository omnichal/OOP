import java.util.Scanner;

public class CarFactory {
    public Car getNewCar (){
        int ch;
        Car c;
        Scanner sc= new Scanner(System.in);
        do{
            System.out.println("-----------------------");
            System.out.println("\t\tMenu");
            System.out.println("-----------------------");
            System.out.println("1. SUV");
            System.out.println("2. Sedan");
            System.out.println("3. Hatchback");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            ch=sc.nextInt();
        switch (ch){
            case 1:
                c=new SUV();
                c.CarSpec();
                break;
            case 2:
                c=new Sedan();
                c.CarSpec();
                break;
            case 3:
                c=new HatchBack();
                c.CarSpec();
                break;
            case 4:
                ch=4;
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        }while (ch!=4);
        return null;
    }
}
