import java.util.Scanner;

public class Rectangle extends Shape{
    @Override
    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Height: ");
        x = sc.nextDouble();
        System.out.println("Enter the value of Breadth: ");
        y = sc.nextDouble();
    }

    @Override
    public void compute_area() {
        double area=x*y;
        System.out.println("Area is: "+area);
    }
}
