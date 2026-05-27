package bankingsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService cs = new CustomerService();
        AccountService as = new AccountService();
        TransactionService ts = new TransactionService();

        while (true) {

            System.out.println("\n1 Add Customer");
            System.out.println("2 Create Account");
            System.out.println("3 Deposit");
            System.out.println("4 Withdraw");
            System.out.println("5 Exit");

            int option = sc.nextInt();

            if (option == 1) {
                System.out.print("First: ");
                String f = sc.next();

                System.out.print("Last: ");
                String l = sc.next();

                System.out.print("Email: ");
                String e = sc.next();

                System.out.print("Phone: ");
                String p = sc.next();

                cs.addCustomer(f, l, e, p);
            }

            else if (option == 2) {
                System.out.print("Customer ID: ");
                int id = sc.nextInt();

                System.out.print("Type: ");
                String t = sc.next();

                System.out.print("Balance: ");
                double b = sc.nextDouble();

                as.createAccount(id, t, b);
            }

            else if (option == 3) {
                System.out.print("Account ID: ");
                int id = sc.nextInt();

                System.out.print("Amount: ");
                ts.deposit(id, sc.nextDouble());
            }

            else if (option == 4) {
                System.out.print("Account ID: ");
                int id = sc.nextInt();

                System.out.print("Amount: ");
                ts.withdraw(id, sc.nextDouble());
            }

            else {
                break;
            }
        }
    }
}
