import java.io.*;
import java.util.*;
public class Database {
    static Scanner s = new Scanner(System.in);
    static Scanner s1 = new Scanner(System.in);
    static ArrayList<Student> student = new ArrayList<>();
    static File file = new File("Student.txt");
    static ObjectOutputStream oos = null;
    static ObjectInputStream ois = null;
    public void ReadFile() throws Exception {
        ois=new ObjectInputStream(new FileInputStream(file));
        student=(ArrayList<Student>) ois.readObject();
        ois.close();
    }
    public void WriteFile() throws Exception {
        oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(student);
        oos.close();
    }
    public void Insert() throws Exception {
        Student s= new Student();
        student.add(s);
        WriteFile();
    }

    private void search() throws Exception{
        if (file.isFile()){
            ReadFile();
            boolean found=false;
            System.out.print("Enter Student Id: ");
            String id = s.next();
            System.out.println("-------------------------------------------------------------------------------------------");
            Student temp;
            for (int i = 0; i < student.size(); i++) {
                if (Objects.equals(student.get(i).getId(), id)){
                    temp=student.get(i);
                    System.out.println(temp.toString());
                    found=true;
                    System.out.println("-------------------------------------------------------------------------------------------");
                }
            }
            if (!found) {
                System.out.println("Record not Found!");
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }else {
            System.out.println("File does not Exist!!");
        }
    }

    private void clear() throws Exception{
        student.clear();
        if (file.delete()){
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Data cleared Successfully!");
            System.out.println("-------------------------------------------------------------------------------------------");
        }
    }

    private void delete() throws Exception{
        if (file.isFile()){
            ReadFile();
            boolean found=false;
            System.out.print("Enter Student Id: ");
            String id = s.next();
            System.out.println("-------------------------------------------------------------------------------------------");
            Student temp;
            for (int i = 0; i < student.size(); i++) {
                if (Objects.equals(student.get(i).getId(), id)){
                    temp=student.get(i);
                    student.remove(temp);
                    found=true;
                    System.out.println("-------------------------------------------------------------------------------------------");
                }
            }
            if (found) {
                WriteFile();
                System.out.println("Record Deleted Successfully!");
                System.out.println("-------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Record not Found!");
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }else {
            System.out.println("File does not Exist!!");
        }
    }

    private void modify() throws Exception{
        if (file.isFile()){
            ReadFile();
            boolean found=false;
            System.out.print("Enter Student Id: ");
            String id = s.next();
            System.out.println("-------------------------------------------------------------------------------------------");
            Student temp;
            for (int i = 0; i < student.size(); i++) {
                if (Objects.equals(student.get(i).getId(), id)){
                    temp=student.get(i);
                    System.out.println(temp.toString());
                    System.out.println("-------------------------------------------------------------------------------------------");
                    reassign(temp);
                    found=true;
                }
            }
            if (found) {
                WriteFile();
                System.out.println("Record Updated Successfully!");
                System.out.println("-------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Record not Found!");
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }else {
            System.out.println("File does not Exist!!");
        }
    }

    private void reassign(Student temp) {
        int choice = -1;
        do {
            System.out.println("Select Data you want to Change!");
            System.out.println("1.Name");
            System.out.println("2.Student Id");
            System.out.println("3.Address");
            System.out.println("4.Roll no.");
            System.out.println("5.Class");
            System.out.println("6.Marks");
            System.out.println("7.Exit");
            System.out.print("Choice: ");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Change the Name.");
                    System.out.print("Enter new Name: ");
                    String tname = s1.nextLine();
                    temp.setName(tname);
                    student.set(student.indexOf(temp),temp);
                    System.out.println("Record Updated Successfully!");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Change the Student Id.");
                    System.out.print("Enter new Student Id: ");
                    String tid = s.next();
                    temp.setId(tid);
                    student.set(student.indexOf(temp), temp);
                    System.out.println("Record Updated Successfully!");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Change the Address.");
                    System.out.print("Enter new Address: ");
                    String taddress = s1.nextLine();
                    temp.setAddress(taddress);
                    student.set(student.indexOf(temp), temp);
                    System.out.println("Record Updated Successfully!");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Change the Roll No.");
                    System.out.print("Enter new Roll No: ");
                    int troll = s.nextInt();
                    temp.setRoll(troll);
                    student.set(student.indexOf(temp), temp);
                    System.out.println("Record Updated Successfully!");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("Change the Class.");
                    System.out.print("Enter new Class: ");
                    String tclass = s.next();
                    temp.setStd(tclass);
                    student.set(student.indexOf(temp), temp);
                    System.out.println("Record Updated Successfully!");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case 6:
                    System.out.println("Change the Name.");
                    System.out.print("Enter new Name: ");
                    int tmarks = s.nextInt();
                    temp.setMarks(tmarks);
                    student.set(student.indexOf(temp), temp);
                    System.out.println("Record Updated Successfully!");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case 7:
                    choice = 7;
                    break;
                default:
                    System.out.println("Enter Valid Input!");
            }
        } while (choice != 7);
    }

    private void display() throws Exception{
        if (file.isFile()){
            ReadFile();
            System.out.println("-------------------------------------------------------------------------------------------");
            for (int i = 0; i < student.size(); i++) {
                System.out.println(student.get(i).toString());
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }else {
            System.out.println("File does not Exist!!");
        }
    }
    public void menu(){
        int choice = 0;
        do {
            System.out.println("Menu: ");
            System.out.println("1.Add Student Data");
            System.out.println("2.Display Student Data");
            System.out.println("3.Modify Student Data");
            System.out.println("4.Delete Specific Student Data");
            System.out.println("5.Clear Whole Student Data");
            System.out.println("6.Search Student Data");
            System.out.println("7.Exit");
            System.out.print("Choice: ");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    try {
                        Insert();
                    } catch (Exception e) {
                        System.out.println("Error Resolved!");
                        menu();
                    }
                    break;
                case 2:
                    try {
                        display();
                    } catch (Exception e) {
                        System.out.println("Error Resolved!");
                        menu();
                    }
                    break;
                case 3:
                    try {
                        modify();
                    } catch (Exception e) {
                        System.out.println("Error Resolved!");
                        menu();
                    }
                    break;
                case 4:
                    try {
                        delete();
                    } catch (Exception e) {
                        System.out.println("Error Resolved!");
                        menu();
                    }
                    break;
                case 5:
                    try {
                        clear();
                    } catch (Exception e) {
                        System.out.println("Error Resolved!");
                        menu();
                    }
                    break;
                case 6:
                    try {
                        search();
                    } catch (Exception e) {
                        System.out.println("Error Resolved!");
                        menu();
                    }
                    break;
                case 7:
                    choice = 7;
                    break;
                default:
                    System.out.println("Invalid Input!!");
                    break;
            }
        } while (choice != 7);
    }
}
