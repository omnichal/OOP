import java.util.Scanner;

public class BitCoin implements PaymentMethod{
    private String walletId;
    private double walletNumber;
    private String walletPassword;
    Scanner sc = new Scanner(System.in);
    BitCoin() {
        System.out.print("Enter Wallet Id: ");
        this.walletId= sc.next();
        System.out.print("Enter Wallet No.: ");
        this.walletNumber=sc.nextDouble();
        System.out.print("Enter Password: ");
        this.walletPassword=sc.next();
    }

        @Override
    public void pay(double amount) {
            System.out.println(amount+"Paid with BitCoin.");
        }
}
