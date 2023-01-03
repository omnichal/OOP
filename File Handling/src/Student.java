import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private String name,id,address,std;
    private int roll,marks;
    static Scanner s =new Scanner(System.in);
    static Scanner s1=new Scanner(System.in);
    public Student(){
        System.out.print("Enter your Name: ");
        name = s1.nextLine();
        System.out.print("Enter your Student Id: ");
        id = s.next();
        System.out.print("Enter your Address: ");
        address = s1.nextLine();
        System.out.print("Enter your Roll No.: ");
        roll = s.nextInt();
        System.out.print("Enter your Class: ");
        std = s.next();
        System.out.print("Enter your Marks: ");
        marks = s.nextInt();
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return  "Name: " + name + "\nAddress: " + address + "\nRoll No.: " + roll + "\nStudent Id: " + id + "\nClass: " + std + "\nMarks: " + marks;
    }
}
