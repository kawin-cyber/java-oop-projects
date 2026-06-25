import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposit successful! New balance: Rs.%.2f%n", balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (balance - amount < 1000) {
            throw new InsufficientFundsException(
                    "Transaction denied: Minimum balance of Rs.1000 must be maintained."
            );
        }
        balance -= amount;
        System.out.printf("Withdrawal successful! Remaining balance: Rs.%.2f%n", balance);
    }

    public void displayBalance() {
        System.out.printf("Account No: %d | Holder: %s | Balance: Rs.%.2f%n",
                accountNumber, holderName, balance);
    }
}

public class BankSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Welcome to SBI Bank of India -----");
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, name, balance);

        while (true) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);

            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                try {
                    account.withdraw(withdrawAmount);
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 3) {
                account.displayBalance();

            } else if (choice == 4) {
                System.out.println("Thank you for banking with us!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
