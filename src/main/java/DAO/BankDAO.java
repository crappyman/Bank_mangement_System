package DAO;

import Model.Customer;
import Model.Employee;
import exception.SystemException;

import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public interface BankDAO {

    List<Customer> fetchAllCustomers() throws SystemException, AccountNotFoundException;

    List<Employee> fetchAllEmployees() throws SystemException, AccountNotFoundException;

    Customer fetchAcount(int accountNo);

    Customer createAccount(Customer cus) throws SystemException;

  

    boolean transfer(int fromAccountNo, int toAccountNo, double amount) throws SystemException, Exception;

	//double withdraw(int accountNo, double amount);

}
