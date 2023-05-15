package BankingApplication2;

public class Account {
    private int accoutNumber;
    private double balanced;
    private  String accountName;
    public Account(int accoutNumber, String accountName, double balanced) {
        this.accountName = accountName;
        this.accoutNumber = accoutNumber;
        this.balanced = balanced;
    }
    
    public void deposit(double amount){
        this.balanced = balanced + amount;
    }

    public void withdraw(double amount) {
        this.balanced = balanced - amount;
    }

    public double getBalance() {
       return this.balanced;
    }

    public int getAccountNumber() {
        return this.accoutNumber;
    }
    
    public String getAccountName() {
        return this.accountName;
    }
}
