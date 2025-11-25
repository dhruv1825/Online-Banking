import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankOperation bank = new BankOperation();

        // menu until user exits 
        while (true) {
            // display menu options 

            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt(sc); // user menu (reads whole line safely)

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine().trim(); // read whole name line

                System.out.print("Enter Initial Amount: ");
                double amt = readDouble(sc); // read as double safely

                // created new acc using bank ope. method
                int accNo = bank.createAccount(name, amt);

                System.out.println("Account Created! Account Number: " + accNo);
            }

            // OPTION 2 : DEPOSIT MONEY
            else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                int accNo = readInt(sc);

                // find acc. in list
                Account acc = bank.findAccount(accNo);

                if (acc == null) {
                    System.out.println("Account not found!");
                } else {
                    System.out.print("Enter the amount to be deposited: ");
                    double amt = readDouble(sc);

                    acc.deposit(amt); // calling deposit method
                    System.out.println("Money Deposited successfully");
                }
            }

            // OPTION 3 : WITHDRAW MONEY
            else if (choice == 3) {
                System.out.print("Enter account number: ");
                int accNo = readInt(sc);

                // find account
                Account acc = bank.findAccount(accNo);

                if (acc == null) {
                    System.out.println("Account not found");
                } else {
                    System.out.print("Enter the amount to be withdrawn: ");
                    double amt = readDouble(sc);

                    // call withdraw method
                    boolean ok = acc.withdraw(amt);
                    if (ok) {
                        System.out.println("Withdrawn Successfully!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                }
            }

            // OPTION 4: CHECK BALANCE
            else if (choice == 4) {
                System.out.print("Enter account number: ");
                int accNo = readInt(sc);

                // find account
                Account acc = bank.findAccount(accNo);
                if (acc == null) {
                    System.out.println("Account not found!");
                } else {
                    System.out.println("Current Balance: ₨ " + acc.balance);
                }
            }

            // OPTION 5 : EXIT THE PROGRAM
            else if (choice == 5) {
                System.out.println("Thank you for using Banking System!");
                break; // exit 
            } else {
                System.out.println("Please enter a valid option (1 - 5).");
            }

            System.out.println();
        }

        sc.close();
    }

    // Helper: read an integer safely from a full input line
    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid integer: ");
            }
        }
    }

    // Helper: read a double safely from a full input line
    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v < 0) {
                    System.out.print("Amount can't be negative. Enter again: ");`
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
    }
}

//javac *.java
// java Main