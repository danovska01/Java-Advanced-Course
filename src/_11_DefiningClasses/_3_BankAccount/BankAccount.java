package _11_DefiningClasses._3_BankAccount;

public class BankAccount {
    //interest rate: double (Shared for all accounts. Default value: 0.02)
    //
    private static double interestRate = 0.02;
    private static int accountsCount = 0;

    private int id;
    private double balance;

    public BankAccount() {
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    //getInterest(int Years): double
    public double getInterestRate(int years) {
        return years * this.getBalance()*interestRate;
    }

   //setInterestRate(double interest): void (static)
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    //deposit(double amount): void
    public void deposit(double amount) {
        this.balance += amount;
    }
}
