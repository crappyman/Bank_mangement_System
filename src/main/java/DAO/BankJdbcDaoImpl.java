package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Model.Customer;
import Model.Employee;
import exception.SystemException;

public class BankJdbcDaoImpl implements BankDAO {
	public static final Logger LOG = LogManager.getLogger(BankJdbcDaoImpl.class);

	@Override
	public List<Customer> fetchAllCustomers() throws SystemException, AccountNotFoundException {
		LOG.info("Exit fetchAllCustomers() in DAO");
		List<Customer> allCustomer = new ArrayList<Customer>();
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from customer_details";

			ResultSet rs = stmt.executeQuery(query);

// iterate through the result set 
			while (rs.next()) {

				Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));

				allCustomer.add(customer);
			}
		} catch (SQLException e) {

		}
		if (allCustomer.isEmpty()) {
			throw new AccountNotFoundException();
		}
		LOG.info("Exited fetchAllCustomers() in DAO");
		return allCustomer;
	}

	@Override
	public List<Employee> fetchAllEmployees() throws SystemException, AccountNotFoundException {
		LOG.info("Entered fetchAllEmployees() in DAO");

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
		LOG.info("Exit fetchAllEmployees() in DAO");
		return allEmployee;
	}

	@Override
	public Customer fetchAcount(int accountNo) {
		LOG.info("Entered fetchAcount() in DAO");
		Customer customer = null;
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			String query = "SELECT * FROM customer_details WHEERE account_no=" + accountNo;
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		LOG.info("Exit fetchAcount() in DAO");
		return customer;
	}

	@Override
	public Customer createAccount(Customer cus) throws SystemException {
		LOG.info("Entered createAccount() in DAO");
		Connection conn = DBUtil.obtainConnection();
		try {
			Statement stmt = conn.createStatement();
			int lastAccount = 0;
			String query1 = "SELECT MAX(account_no) FROM customer_details";
			ResultSet rs = stmt.executeQuery(query1);
			if (rs.next()) {
				lastAccount = rs.getInt(1);
			}
			int newAccount = lastAccount + 1;

			String query2 = "INSERT INTO customer_details VALUES(" + newAccount + ",'" + cus.getName() + "','"
					+ cus.getPassword() + "','" + cus.getBalance() + "')";
			int rows = stmt.executeUpdate(query2);
			cus.setAccountNo(newAccount);
		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exit createAccount() in DAO");
		return cus;
	}

	@Override
	public boolean transfer(int fromAccountNo, int toAccountNo, double amount) throws SystemException, Exception {
		Connection conn = DBUtil.obtainConnection();
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		String query1 = "UPDATE customer_details SET balance=balance-" + amount + " WHERE account_no=" + fromAccountNo;
		String query2 = "UPDATE customer_details SET balance=balance+" + amount + " WHERE account_no=" + toAccountNo;

		
conn.setAutoCommit(false);
		 
		int rows1 = stmt.executeUpdate(query1);
        int rows = stmt.executeUpdate(query2);
		
		conn.commit();
		System.out.println("Money transfered...");

		
		conn.rollback();

		return true;

	}
}
