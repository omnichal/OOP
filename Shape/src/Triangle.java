import java.util.Scanner;

public class Triangle extends Shape{
    @Override
    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Height: ");
        x = sc.nextDouble();
        System.out.println("Enter the value of Base: ");
        y = sc.nextDouble();
    }

    @Override
    public void compute_area() {
        double area=0.5*x*y;
        System.out.println("Area is: "+area);
    }
}
