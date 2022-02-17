package DAO;

import Model.Customer;
import Model.Employee;
import java.util.ArrayList;
import java.util.List;

public class BankDAOImp implements BankDAO {

    List<Customer> listCustomers;
    List<Employee> listEmployee;

    public BankDAOImp() {

        listCustomers = new ArrayList<>();
        listEmployee = new ArrayList<>();

        createAccount(new Customer("TestUser1", "qwerty1", 100));
        createAccount(new Customer("TestUser2", "qwerty2", 150));

        //add employee 
        listEmployee.add(new Employee("employee1", "abcd"));
        listEmployee.add(new Employee("employee2", "1234"));
        listEmployee.add(new Employee("employee3", "asdf"));
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return listCustomers;
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return listEmployee;
    }

    @Override
    public Customer fetchAcount(int accountNo) {
        for (Customer cus : listCustomers) {
            if (cus.getAccountNo() == accountNo) {
                return cus;
            }
        }
        return null;
    }

    @Override
    public int createAccount(Customer cus) {
        if (!listCustomers.isEmpty()) {
            cus.setAccountNo(listCustomers.get(listCustomers.size() - 1).getAccountNo() + 1);
        } else {
            cus.setAccountNo(1001);
        }
        cus.setStatus("Active");
        listCustomers.add(cus);
        return listCustomers.get(listCustomers.size() - 1).getAccountNo();
    }

    @Override
    public double deposit(int accountNo, double amount) {
        if (amount > 0) {
            for (Customer cus : listCustomers) {
                if (cus.getAccountNo() == accountNo) {
                    cus.setBalance(cus.getBalance() + amount);
                    return cus.getBalance();
                }
            }
        }

        return -1;
    }

    @Override
    public double withdraw(int accountNo, double amount) {
        for (Customer cus : listCustomers) {
            if (cus.getAccountNo() == accountNo && cus.getBalance() >= amount) {
                cus.setBalance(cus.getBalance() - amount);
                return cus.getBalance();
            }
        }

        return -1;
    }

    @Override
    public double transfer(int fromAccountNo, int toAccountNo, double amount) {

        boolean flag = false;
        for (Customer cus : listCustomers) {
            if (cus.getAccountNo() == toAccountNo) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (Customer cus : listCustomers) {
                if (cus.getAccountNo() == fromAccountNo && cus.getBalance() >= amount) {
                    flag = false;
                    for (Customer cus1 : listCustomers) {
                        if (cus1.getAccountNo() == toAccountNo) {
                            cus1.setBalance(cus1.getBalance() + amount);
                            break;
                        }
                    }
                    cus.setBalance(cus.getBalance() - amount);
                    return cus.getBalance();
                }
            }
        }

        if (flag) {
            return 0;
        }

        return -1;
    }

}
