import java.util.Scanner;
public class Assistant_Professor extends Person{
    Scanner sc=new Scanner(System.in);
    private String branch;
    private int basic_pay=15600;

    @Override
    public void getdata() {
        super.getdata();
        System.out.print("Enter your Branch: ");
        branch=sc.next();
        System.out.print("Basic Pay: ");
        basic_pay=sc.nextInt();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Branch: "+branch);
        System.out.println("Basic Pay: "+basic_pay);
        System.out.println("Salary: "+salary());
    }

    private double salary() {
        double gross,net;
        gross=basic_pay*1.49;
        net=gross-(basic_pay*0.121);
        return net;
    }
}


