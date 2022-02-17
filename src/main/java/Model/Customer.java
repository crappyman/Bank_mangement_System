package Model;

public class Customer {

    private int accountNo;
    private String name;
    private String password;
    private double balance;
    private String status;

    public Customer(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.status = "Processing";
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nAccountNo: " + accountNo + "\nName: " + name + "\nPassword: " + password + "\nBalance: " + balance + "\nStatus: " + status;
    }

}
