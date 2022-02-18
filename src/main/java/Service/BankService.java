package Service;

import Model.Customer;
import Model.Employee;
import exception.SystemException;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public interface BankService {

    List<Customer> fetchAllCustomers() throws AccountNotFoundException, SystemException;

    List<Employee> fetchAllEmployees() throws AccountNotFoundException, SystemException;

    Customer fetchAcount(int accountNo);

    int createAccount(Customer cus) throws SystemException;

  //  double deposit(int accountNo, double amount);

  //  double withdraw(int accountNo, double amount);

    double transfer(int fromAccountNo, int toAccountNo, double amount) throws SystemException, Exception;
}
