import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        Bag [] bags= new Bag[100];
        try {
            menu(bags);
        }catch (Exception e){
            menu(bags);
        }
    }

    private static void menu(Bag [] bags) {
        int ch;
        do {
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    add(bags);
                    break;
                case 2:
                    delete(bags);
                    break;
                case 3:
                    display(bags);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input, therefore Showing Result");
                    display(bags);
                    break;
            }
        }while (ch!=4);
    }

    private static void display(Bag [] bags) {
        System.out.println("==============================================================================================");
        System.out.println("Sr.no\t\t\t\t\tColor\t\t\t\t\tWeight");
        System.out.println("==============================================================================================");
        for (int i = 0; i < Bag.getTotalballs(); i++) {
            if (bags[i]!=null){
                System.out.print("  "+(i+1)+"       ");
                bags[i].display();
            }

        }
        System.out.println("==============================================================================================");
        System.out.println("\t\t\t\t\t\tTotal");
        System.out.println("==============================================================================================");
        System.out.println("  "+ Bag.getTotalballs()+" :Total Balls\t\t\t\t  Total Weight: "+ Bag.getTotalweight());
        System.out.println("\n");
    }

    private static void delete(Bag [] bags) {
        int index;
        System.out.print("Enter the Ball Number to be removed: ");
        index= sc.nextInt();
        bags[index-1].RemoveWeight();
        for (int i = index-1; i <Bag.getTotalballs() ; i++) {
            if ((i+1)<Bag.getTotalballs()){
                bags[i]=bags[i+1];
            }
        }
        bags[bags.length-1]=null;
    }

    private static void add(Bag [] bags) {
        int choice;
        String color;
        double weight;
        do {
            System.out.println("Add Item");
            System.out.println("1. Enter Color & Weight Manually");
            System.out.println("2. Enter Color Manually");
            System.out.println("3. Enter Weight Manually");
            System.out.println("4. Take both Default");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Color: ");
                    color = sc.next();
                    System.out.print("Weight: ");
                    weight = sc.nextDouble();
                    bags[Bag.getTotalballs()]=new Bag(color,weight);
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.print("Color: ");
                    color = sc.next();
                    bags[Bag.getTotalballs()]=new Bag(color);
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.print("Weight: ");
                    weight = sc.nextDouble();
                    bags[Bag.getTotalballs()]=new Bag(weight);
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                case 4:
                    bags[Bag.getTotalballs()]=new Bag();
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                case 5:
                    choice=5;
                    break;
                default:
                    System.out.println("Invalid Choice!!!");
                    add(bags);
                    break;
            }
        }while (choice!=5);
        
    }
}
