package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import Model.Customer;
import Model.Employee;
import exception.SystemException;

public class BankJdbcDaoImpl implements BankDAO {

	@Override
	public List<Customer> fetchAllCustomers()throws SystemException, AccountNotFoundException
	{
		List<Customer> allCustomer = new ArrayList<Customer>();
	Connection conn=DBUtil.obtainConnection();
  try {
	Statement stmt =(Statement) conn.createStatement();
String query ="SELECT * FROM customer_details";
		
ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
// iterate through the result set 
while(rs.next()) {
	
	Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getDouble(3));
	
	allCustomer.add(customer);
}
} catch (SQLException e) {
throw new SystemException();
}
if(allCustomer.isEmpty()) {
throw new AccountNotFoundException();
}

return allCustomer;
	}
	

	@Override
	public List<Employee> fetchAllEmployees() throws SystemException, AccountNotFoundException{
		
		List<Employee> allEmployee = new ArrayList<Employee>();
		Connection conn=DBUtil.obtainConnection();
	  try {
		Statement stmt =(Statement) conn.createStatement();
	String query ="SELECT * FROM employee_details";
			
	ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
	// iterate through the result set 
	while(rs.next()) {
		
		Employee employee = new Employee(rs.getString(1), rs.getString(2));
		
		allEmployee.add(employee);
	}
	} catch (SQLException e) {
	throw new SystemException();
	}
	if(allEmployee.isEmpty()) {
	throw new AccountNotFoundException();
	}

	return allEmployee;
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
	public int createAccount(Customer cus) throws SystemException{
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
