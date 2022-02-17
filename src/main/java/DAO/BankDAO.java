package DAO;

import Model.Customer;
import Model.Employee;
import exception.SystemException;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public interface BankDAO {

    List<Customer> fetchAllCustomers() throws SystemException, AccountNotFoundException;

    List<Employee> fetchAllEmployees() throws SystemException, AccountNotFoundException;

    Customer fetchAcount(int accountNo);

    int createAccount(Customer cus) throws SystemException;

    double deposit(int accountNo, double amount);

    double withdraw(int accountNo, double amount);

    double transfer(int fromAccountNo, int toAccountNo, double amount);

}
