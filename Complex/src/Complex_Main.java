public class Complex_Main {
    public static void main(String[] args) {
        Complex_Class c1=new Complex_Class();
        Complex_Class c2=new Complex_Class();
        Complex_Class c3=new Complex_Class();
        System.out.println("Enter the First Complex Number: ");
        c1.getdata();
        System.out.println("Enter the Second Complex Number: ");
        c2.getdata();
        for(;;){
            c3.operation(c1, c2);
        }

    }
}
