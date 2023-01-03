import java.util.*;
public class Arraylist {
    private ArrayList<Integer> numList = new ArrayList<>();
    private ArrayList<String> stringList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    void add(Boolean string) {
        if(string) {
            System.out.println("Enter a string: ");
            String s = sc.next();
            stringList.add(s);
        }else {
            System.out.println("Enter a number: ");
            int s = sc.nextInt();
            numList.add(s);
        }
    }

    void display() {
        System.out.println(stringList);
        System.out.println(numList);
    }



    void classifyEvenOdd(){
        ArrayList<Integer> odd = new ArrayList<>();
        int count = 0;
        //System.out.println("Even: ");
        for (int i = 0; i < numList.size(); i++){
            if (numList.get(i) % 2 == 0){
                System.out.println("Even: "+numList.get(i));
                count++;
            }
            else {
                odd.add(numList.get(i));
            }
        }
        System.out.println("Total Even numbers: "+count);
        //System.out.println("Odd:");
        for (int i =0; i < odd.size(); i++ ){
            System.out.println("Odd:"+odd.get(i));
        }
        System.out.println("Total Odd numbers: "+odd.size());

    }
    boolean isPrime(int number){
        boolean prime = false;
        if (number == 1){
            prime = false;
            return prime;
        }
        else if (number == 2){
            prime = true;
            return prime;
        }
        if ( number % 2 == 0){
            prime = false;
            return prime;
        }

        else {
            if (number == 3){
                prime = true;
                return prime;
            }
            else {
                for (int i =  3; i <= Math.ceil(Math.sqrt(number)); i+=2) {
                    if (number % i == 0){
                        prime = false;
                        break;
                    }
                    else {
                        prime = true;
                    }

                }
            }
        }
        return prime;
    }
    void classifyPrime(){
        //System.out.println("Prime: ");
        int countP = 0, countNP = 0;
        ArrayList<Integer> Notprime = new ArrayList<>();
        for(int i = 0; i < numList.size(); i++ ) {
            if(!isPrime(numList.get(i))) {
                Notprime.add(numList.get(i));
                countNP++;
            }
            else {
                System.out.println("Prime: "+numList.get(i));
                countP++;
            }
        }
        System.out.println("Total Primes: "+countP);
        //System.out.println("Not Prime: ");
        for(int i = 0; i < Notprime.size();i++) {
            System.out.println("Not Prime: "+Notprime.get(i));
        }
        System.out.println("Total Non Primes: "+countP);
    }

    String Pallindrome(String s) {
        StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1.reverse();
        s= String.valueOf(s1);
        return s;
    }

    void checkPallindrome() {
        for(int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).equals(Pallindrome(stringList.get(i)))) {
                System.out.println(stringList.get(i)+" is a Pallindrome");
            }
            else {
                System.out.println(stringList.get(i)+" is not a Pallindrome");
            }
        }
    }


}