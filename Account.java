public class Account {
    int accountNumber; // unique number of every bank account
    String holderName; // name of account holder
    double balance; // curr balance in account

    // constructor when account is created 
    public Account(int accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber; // assign acc no
        this.holderName = holderName; // assign customer name
        this.balance = balance; // initial baalnce
        
    }

    // method to deposit the money

    public void deposit(double amount){
        balance = balance + amount;// money added to balance

    }

    // method to withdraw
    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }
        balance = balance - amount;
        return true;
    }
}
