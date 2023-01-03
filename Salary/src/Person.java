import java.util.Scanner;

public class Person {
    Scanner sc=new Scanner(System.in);
    private String name;
    private String employeeid;
    private String dob;
    private String pancard;
    private String gender;
    private String address;
    public void getdata(){
        System.out.print("Enter your Name: ");
        name=sc.next();
        System.out.print("Enter your Gender: ");
        gender=sc.next();
        System.out.print("Enter your Date of Birth: ");
        dob= sc.next();
        System.out.print("Enter your Pan Card No.: ");
        pancard=sc.next();
        System.out.print("Enter your Address: ");
        address=sc.next();
        System.out.print("Enter your Employee Id: ");
        employeeid=sc.next();
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
        System.out.println("Date of Birth: "+dob);
        System.out.println("Gender: "+gender);
        System.out.println("Pan Card No.: "+pancard);
        System.out.println("Employee Id: "+employeeid);
    }

}
