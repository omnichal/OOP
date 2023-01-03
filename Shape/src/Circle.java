import java.util.Scanner;

public class Circle extends Shape{

    @Override
    public void getdata() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of Radius: ");
        x=sc.nextDouble();
    }

    @Override
    public void compute_area() {
        double area=3.142*x*x;
        System.out.println("Area is: "+area);
    }
}
