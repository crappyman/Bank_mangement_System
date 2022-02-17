package Service;

import DAO.BankDAOImp;
import Model.Customer;
import Model.Employee;
import java.util.List;

public class BankServiceImp implements BankService {

    BankDAOImp bankDAO;

    public BankServiceImp() {
        bankDAO = new BankDAOImp();
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return bankDAO.fetchAllCustomers();
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return bankDAO.fetchAllEmployees();
    }

    @Override
    public Customer fetchAcount(int accountNo) {
        return bankDAO.fetchAcount(accountNo);
    }

    @Override
    public int createAccount(Customer cus) {
        return bankDAO.createAccount(cus);
    }

    @Override
    public double deposit(int accountNo, double amount) {
        return bankDAO.deposit(accountNo, amount);
    }

    @Override
    public double withdraw(int accountNo, double amount) {
        return bankDAO.withdraw(accountNo, amount);
    }

    @Override
    public double transfer(int fromAccountNo, int toAccountNo, double amount) {
        return bankDAO.transfer(fromAccountNo, toAccountNo, amount);
    }

}
