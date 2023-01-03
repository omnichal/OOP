import java.util.Scanner;

class Exception_Handling {
    public static void Run(){
        Arithmetic_Operation aop = new Arithmetic_Operation();
        try {
            aop.getdata();
            aop.division();
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception is Handled!");
        } catch (NullPointerException e) {
            System.out.println("Runtime Exception is Handled!");
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception is Handled!");
        }
        System.out.println("Division is Finished");
    }


    public static void main(String[] args) {
        Run();
        int con;
        do {
            Scanner sc=new Scanner(System.in);
            con = 0;
            System.out.println("Do you want to\n1.Continue\n2.Exit");
            System.out.print("Choice: ");
            con=sc.nextInt();
            if (con==1){
                Run();
            }
            else
                break;
        } while (con==1);

    }
}