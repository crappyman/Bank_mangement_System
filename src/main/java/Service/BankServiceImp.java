package Service;

import DAO.BankDAO;

import DAO.BankJdbcDaoImpl;
import Model.Customer;
import Model.Employee;
import exception.SystemException;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public class BankServiceImp implements BankService {

    BankDAO bankDAO;

    public BankServiceImp() {
      
    	bankDAO = new BankJdbcDaoImpl();
    }

    @Override
    public List<Customer> fetchAllCustomers() throws AccountNotFoundException, SystemException {
        return bankDAO.fetchAllCustomers();
    }

    @Override
    public List<Employee> fetchAllEmployees() throws AccountNotFoundException, SystemException {
        return bankDAO.fetchAllEmployees();
    }

    @Override
    public Customer fetchAcount(int accountNo) {
        return bankDAO.fetchAcount(accountNo);
    }

    @Override
    public Customer createAccount(Customer cus) throws SystemException {
        return bankDAO.createAccount(cus);
    }

   // @Override;
   // public double deposit(int accountNo, double amount) {
     //   return bankDAO.deposit(accountNo, amount);
   // }

  /* @Override
    public double withdraw(int accountNo, double amount) {
       return bankDAO.withdraw(accountNo, amount);
       
   // }
*/
    @Override
    public boolean transfer(int fromAccountNo, int toAccountNo, double amount) throws SystemException, Exception {
        return bankDAO.transfer(fromAccountNo, toAccountNo, amount);
    }

}
