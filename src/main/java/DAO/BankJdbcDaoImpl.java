package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.Customer;
import Model.Employee;

public class BankJdbcDaoImpl implements BankDAO {

	@Override
	public List<Customer> fetchAllCustomers() {
//	Connection conn=DBUtil.obtainConnection();
//	Statement stmt =(Statement) conn.createStatement();
//	String query =;
		// stmt.executeUpdata(query);
	return null;
	}
	

	@Override
	public List<Employee> fetchAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer fetchAcount(int accountNo) {
		Customer customer=null;
		Connection conn=DBUtil.obtainConnection();
		try {
			Statement stmt =(Statement) conn.createStatement();
			String query="SELECT * FROM customer_details WHEERE account_no="+accountNo;
			ResultSet rs=((java.sql.Statement) stmt).executeQuery(query);
			if(rs.next()) {
				customer=new Customer(rs.getString(1),rs.getString(2),rs.getDouble(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int createAccount(Customer cus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit(int accountNo, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw(int accountNo, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transfer(int fromAccountNo, int toAccountNo, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
