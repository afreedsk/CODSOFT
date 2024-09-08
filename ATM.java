import java.util.Scanner;

// Class to represent the user's bank account
class ATMInterface
 {
    private double balance;

    // Constructor to initialize account balance
    public ATMInterface(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance()
    {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount)
    {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Class to represent the ATM machine
public class ATM 
{
    //Starting balance of $1000
    private static ATMInterface account = new ATMInterface(1000);  

    // Method to display the ATM menu and handle user input
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
             {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
