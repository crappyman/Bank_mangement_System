package DAO;

import Model.Customer;
import Model.Employee;
import java.util.List;

public interface BankDAO {

    List<Customer> fetchAllCustomers();

    List<Employee> fetchAllEmployees();

    Customer fetchAcount(int accountNo);

    int createAccount(Customer cus);

    double deposit(int accountNo, double amount);

    double withdraw(int accountNo, double amount);

    double transfer(int fromAccountNo, int toAccountNo, double amount);

}
