import  java.util.ArrayList;
public class BankOperation {
    //array list to store multiple acc

    ArrayList<Account> accounts = new ArrayList<>();

    // no keep on increasing for each new acc

    int nextAccountNumber = 1001;

    // method to create a new acc
    public int createAccount(String name, double initialAmount){
        // create a new acc
        
        Account acc = new Account(nextAccountNumber, name, initialAmount);

        // add new account 
        accounts.add(acc);

        // icrease no of acc
        nextAccountNumber++;

        // return new created acc
        return acc.accountNumber;
    }

    // method to find account
    public Account findAccount(int accNo) {

        // loop to find matching account
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;   // return account if found
            }
        }

        
        return null; 
    }
}
