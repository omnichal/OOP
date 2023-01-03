import java.util.Scanner;

public class Complex_Class {
        private double real , img;

        public static int choice;


        public void getdata()
        {
            Scanner sc =new Scanner(System.in);
            real=sc.nextInt();
            img=sc.nextInt();
        }


        public void operation(Complex_Class x,Complex_Class y)
        {
            double a,b,c,d;
            System.out.println("Enter your Choice:");
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            Scanner sc =new Scanner(System.in);
            choice=sc.nextInt();
            a=x.real;
            b=x.img;
            c=y.real;
            d=y.img;

            switch (choice) {
                case 1:
                    System.out.println("Addition" );
                    real=a+c;
                    img=b+d;
                    System.out.println("The Addition of the Complex Numbers is: "+real+" + "+img+"i");
                    break;
                case 2:
                    System.out.println("Subtraction" );
                    real=a-c;
                    img=b-d;
                    System.out.println("The Subtraction of the Complex Numbers is: "+real+" + "+img+"i");
                    break;
                case 3:
                    System.out.println("Multiplication" );
                    real = ((a*c)-(b*d));
                    img = ((a*d)+(b*c));
                    System.out.println("The Multiplication of the Complex Numbers is: "+real+" + "+img+"i");
                    break;
                case 4:
                    System.out.println("Division" );
                    real= (((a*c)+(b*d))/(Math.pow(c, 2) + Math.pow(d, 2)));
                    img=(((a*d)-(b*c))/(Math.pow(c, 2) + Math.pow(d, 2)));
                    System.out.println("The Division of the Complex Numbers is: "+real+" + "+img+"i");
                    break;
                default:
                    System.out.println("Enter a Valid Input!!!!" );
                    break;
            }


        }


}

