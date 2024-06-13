import java.util.Scanner;

public class ATM {


    private Scanner scanner;
    private BankAccount account;

    public ATM(BankAccount account) {
        this.scanner = new Scanner(System.in);
        this.account = account;
    }

    public void run() {
        int choice;

        do {
            System.out.println("\nWelcome to ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw (₹): ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit (₹): ");
        double amount = scanner.nextDouble();

        account.deposit(amount);
        System.out.println("Deposit successful!");
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

 class ATMMain {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Replace with initial balance
        ATM atm = new ATM(account);
        atm.run();
    }
}