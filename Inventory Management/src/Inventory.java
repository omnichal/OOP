import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Record> masterRecords;
    private ArrayList<Record> records;
    private double netProfit;
    static Scanner sc = new Scanner(System.in);
    private int counter = 0;

    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    File file = new File("Stock.ims");


    public Inventory() {
        masterRecords = new ArrayList<>();
        records = new ArrayList<>();
        records.add(new Record("Wheat", "Buy", 100, 18, 30));
        records.add(new Record("Rice", "Buy", 80, 52, 60));
        updateMasterRecords(records);
        updateProfit();
    }
    public void updateProfit(){
        Record temp;
        for (int i =  counter; i < masterRecords.size(); i++) {
            temp = masterRecords.get(counter);
            if (temp.getType().equals("Buy")){
                netProfit -= (temp.getPurchaseRate() * temp.getQuantity());
            }
            else {
                netProfit += (temp.getSellingRate() * temp.getQuantity());
            }
            counter++;
        }

    }

    public void displayRecords(){
        Record temp;
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Sr no.\t\tDate\t\t\t\tParticular\t\t\t\tQuantity\t\tRate\t\t\t  Type");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < records.size(); i++) {
            temp = records.get(i);
            System.out.println(" "+(i+1)+"\t\t  "+temp.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE)+"\t\t\t  "+temp.getName()+"\t\t\t\t\t "+temp.getQuantity()+"\t\t\t"+temp.getSellingRate()+"\t\t\t  "+temp.getType());
            System.out.println("-----------------------------------------------------------------------------------------------------------");
        }
    }

    public void Stock(){
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i+1)+" "+records.get(i).getName());
        }
        System.out.print("Particular: ");
        int st=sc.nextInt();
        Record temp;
                temp = records.get(st-1);
                System.out.println("Name : "+temp.getName());
                System.out.println("Selling price :" + temp.getSellingRate());
                System.out.println("Stock : "+temp.getQuantity());
            }



    private ArrayList<Record> purchase(boolean isSale){
        int input = -1;
        ArrayList<Record> temp = new ArrayList<>();
        String name, type;
        double quantity, purchaseRate, sellingRate;
        System.out.println("Enter '0' as name when done with order.");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        while (true) {
            System.out.println("Enter Name : ");
            name = sc.next();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            if (name.equals("0")){
                break;
            }
            System.out.println("Enter Quantity : ");
            quantity = sc.nextDouble();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("Enter Purchase rate : ");
            purchaseRate = sc.nextDouble();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("Enter Selling Rate : ");
            sellingRate = sc.nextDouble();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            if (isSale){
                type = "Sell";
            }
            else {
                type = "Buy";
            }
            temp.add(new Record(name, type, quantity, purchaseRate, sellingRate));
        }
        return temp;
    }

    public boolean updateRecords(ArrayList<Record> records, boolean isSale){
        Record temp1,temp2;
        boolean updated = false;
        for (int i = 0; i < this.records.size(); i++) {
            for (int j = 0; j < records.size(); j++) {
                temp1 = this.records.get(i);
                temp2 = records.get(j);
                if (temp1.getName().equals(temp2.getName().toUpperCase())){
                    if (!isSale){
                        temp1.setQuantity(temp1.getQuantity() + temp2.getQuantity());
                        temp1.setDateTime(LocalDateTime.now());
                        updated = true;
                    }else {
                        temp1.setQuantity(temp1.getQuantity() - temp2.getQuantity());
                        temp1.setDateTime(LocalDateTime.now());
                        updated = true;
                    }

                }
            }

        }
        return updated;
    }

    public boolean containsRecord(String name){
        boolean found = false;
        for (int i = 0; i < records.size(); i++) {
            if (name.toUpperCase().equals(records.get(i).getName())){
                found = true;
            }
        }
        return found;
    }
    public void addRecords(ArrayList<Record> temp){
        Record temp1;
        for (int i = 0; i < temp.size(); i++) {
            temp1 = temp.get(i);
            if (!(containsRecord(temp1.getName()))){
                records.add(temp1);
            }
        }
    }


    public void purchaseValidator(){
        ArrayList<Record> temp;
        boolean isSale = false;
        System.out.println("Is it a sale?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter the choice code : ");
        int choice = sc.nextInt();
        if (choice == 1){
            isSale = true;
        }
        temp = purchase(isSale);
        System.out.println("Approve this order?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter the choice code : ");
        choice = sc.nextInt();
        if (choice == 1){
            updateMasterRecords(temp);
            updateRecords(temp, isSale);
            addRecords(temp);
            updateProfit();
        }
        else {
            System.out.println("Your order has been cancelled");
        }
    }



    public void runApp(){
        int input = -1;
        String name;
      while (input != 6){
          System.out.println("1. Display Current Stock");
          System.out.println("2. Lookup a record");
          System.out.println("3. Create a Purchase Order");
          System.out.println("4. Create Sell Invoice");
          System.out.println("5. Show Net Profit");
          System.out.println("6.Exit");
          System.out.print("Choice: ");
            input = sc.nextInt();
            switch (input){
                case 1:
                    displayRecords();
                    break;
                case 2 :
                    Stock();
                    break;
                case 3:
                    purchaseValidator();
                    break;
                case 4:
                    bill();
                    break;
                case 5:
                    System.out.println("Net profit is : "+ netProfit);
                    break;
                case 6:
                    input=6;
                    break;
            }
        }
    }

    private void bill() {
        double total = 0;
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.print("Name: ");
        String Name=sc.next();
        System.out.println("Customer name:\t\t\t\t\t\t\t\t"+Name);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Date : "+LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("Time : "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        Record temp;
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Particular\t\t\t\tDate\t\t\t\tTime\t\t\t\tQuantity\t\tRate");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < records.size(); i++) {
            temp = records.get(i);
            System.out.println(temp.getName() + "\t\t\t\t\t" + temp.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\t\t\t" + temp.getDateTime().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + "\t\t\t" + temp.getQuantity() + "\t\t\t" + temp.getSellingRate() + "\t\t");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            total = (temp.getQuantity() * (temp.getSellingRate()));
        }


        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Total : \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tzip"+total);
        System.out.println("Thank you for shopping with us!");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    private void updateMasterRecords(ArrayList<Record> records){
        Record temp;
        for (int i = 0; i < records.size(); i++) {
            temp = records.get(i);
            masterRecords.add(new Record(temp.getName(), temp.getType(), temp.getQuantity(), temp.getPurchaseRate(), temp.getSellingRate()));
        }
    }


    public void writeFile() throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(file,false));
        oos.writeObject(masterRecords);
        oos.writeObject(records);
        oos.close();
    }
    public void readFile() throws Exception {
        ois = new ObjectInputStream(new FileInputStream(file));
        masterRecords = (ArrayList<Record>) ois.readObject();
        records = (ArrayList<Record>) ois.readObject();
        ois.close();
    }
}