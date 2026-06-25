import java.util.Scanner;

// Abstract class (Abstraction)
abstract class BankAccount {
    int accountNumber;
    String accountHolderName;
    String accountType;
    String branchName;
    double balance;

    BankAccount(int accNo, String name, String type, String branch, double bal) {
        accountNumber = accNo;
        accountHolderName = name;
        accountType = type;
        branchName = branch;
        balance = bal;
    }

    abstract void displayDetails();
}

// Concrete class
class AccountDetails extends BankAccount {

    AccountDetails(int accNo, String name, String type, String branch, double bal) {
        super(accNo, name, type, branch, bal);
    }

    @Override
    void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Branch Name    : " + branchName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("-------------------------------");
    }
}

public class BankManagementAbstraction{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();

        BankAccount[] accounts = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Account " + (i + 1));

            System.out.print("Account Number: ");
            int accNo = sc.nextInt();

            sc.nextLine();
            System.out.print("Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Account Type (Savings/Current): ");
            String type = sc.nextLine();

            System.out.print("Branch Name: ");
            String branch = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();

            accounts[i] = new AccountDetails(accNo, name, type, branch, balance);
        }

        System.out.println("\n--- Bank Account Information ---");
        for (int i = 0; i < n; i++) {
            accounts[i].displayDetails();
        }

        sc.close();
    }
}
