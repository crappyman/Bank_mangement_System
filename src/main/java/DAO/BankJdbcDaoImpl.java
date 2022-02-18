package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import Model.Customer;
import Model.Employee;
import exception.SystemException;

public class BankJdbcDaoImpl implements BankDAO {

	@Override
	public List<Customer> fetchAllCustomers() throws SystemException, AccountNotFoundException {
		List<Customer> allCustomer = new ArrayList<Customer>();
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM customer_details";

			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
// iterate through the result set 
			while (rs.next()) {

				Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getDouble(3));

				allCustomer.add(customer);
			}
		} catch (SQLException e) {

		}
		if (allCustomer.isEmpty()) {
			throw new AccountNotFoundException();
		}

		return allCustomer;
	}

	@Override
	public List<Employee> fetchAllEmployees() throws SystemException, AccountNotFoundException {

		List<Employee> allEmployee = new ArrayList<Employee>();
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM employee_details";

			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the result set
			while (rs.next()) {

				Employee employee = new Employee(rs.getString(1), rs.getString(2));

				allEmployee.add(employee);
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		if (allEmployee.isEmpty()) {
			throw new AccountNotFoundException();
		}

		return allEmployee;
	}

	@Override
	public Customer fetchAcount(int accountNo) {
		Customer customer = null;
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM customer_details WHEERE account_no=" + accountNo;
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			if (rs.next()) {
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getDouble(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int createAccount(Customer cus) throws SystemException {
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			int lastAccount = 0;
			String query1 = "SELECT MAX(account_no) FROM customer_details";
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query1);
			if (rs.next()) {
				lastAccount = rs.getInt(1);
			}
			int newAccount = lastAccount + 1;

			String query2 = "INSERT INTO customer_details VALUES(" + newAccount + ",'" + cus.getName() + "','"
					+ cus.getPassword() + "','" + cus.getBalance() + "')";
			int rows = ((java.sql.Statement) stmt).executeUpdate(query2);
			cus.setAccountNo(newAccount);
		} catch (SQLException e) {
			throw new SystemException();
		}
		return cus.getAccountNo();
	}


	@Override
	public double transfer(int fromAccountNo, int toAccountNo, double amount) throws SystemException, Exception {
		Connection conn = DBUtil.obtainConnection();
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query1 = "SELECT balance FROM customer_details WHERE  account_no=" + fromAccountNo;
		System.out.println(query1);
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query1);
		double abal = rs.getInt(1);

		double newBalanse = abal + amount;
		String query = "UPDATE customer_details SET balance=" + newBalanse + " WHERE account_no=" + toAccountNo;
		int rows = ((java.sql.Statement) stmt).executeUpdate(query);
		return 0;
	}

}
