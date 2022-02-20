package View;

import Model.Customer;
import Model.Employee;
import Service.BankService;
import Service.BankServiceImp;
import exception.SystemException;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
	public static final Logger LOG = (Logger) LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {

    	BankService bsi = new BankServiceImp();
        Scanner input = new Scanner(System.in);
        ArrayList<Customer> listRequest = new ArrayList<>();

       Customer cust = null;
        Employee empl = null;
        boolean flag = true;
      
        while (flag) {
            System.out.println("=========================");
            System.out.println("Bank MGT");
            System.out.println("=========================");
            System.out.println("1: LOGIN AS Customer");
            System.out.println("2: LOGIN AS AN Employee");
            System.out.println("3: Create Bank Account");
            System.out.println("0: Exit");
            System.out.println("=========================");
            System.out.print("Choice: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("NAME : ");
                    String Name=input.next();
                  
                    System.out.print("PassWord : ");
                    String passWord=input.next(); 
                        	
                

                    boolean match = false;
                   for (Customer cus : bsi.fetchAllCustomers()) {
                	   
                	  if (cus.getName().equals(Name) && cus.getPassword().equals(passWord)) {
                		// System.out.println(bsi.fetchAllCustomers());
                        match = true;
                        cust = cus;
                           break;
                       }
                	
                    }
                  
                    if (match) {

                        while (flag) {
                          
                                System.out.println("=========================");
                                System.out.println("Welcome " + cust.getName());
                                System.out.println("=========================");
                              //  System.out.println("1: Deposit");
                              //  System.out.println("2: Withdraw");
                                System.out.println("3: Transfer");
                                System.out.println("4: Check Balance");
                                System.out.println("0: Logout");
                                System.out.println("=========================");
                                System.out.print("Choice: ");
                                choice = input.nextLine();

                                switch (choice) {
                                    case "1":
                                   
                                        System.out.print("Enter amount: ");
                                        try {
                                            double amount = input.nextDouble();
                                            input.nextLine();
                                            if (amount > 0) {
                                            
                                            } else {
                                                System.out.println("Amount should be greater than 0");
                                            }

                                        } catch (NumberFormatException e)
                                        {
                                        	LOG.error(e);
                                            System.out.println("Amount should be a number");
                                        }
                                        break;
                                    case "2":
                                     
                                        break;
                                    case "3":
                                        System.out.print("Enter Account No. in which you want to transfer: ");
                                     int   accNo = input.nextInt();
                                        input.nextLine();
                                        System.out.print("Enter amount: ");
                                      
                                        try {
                                            double amount = input.nextDouble();
                                            input.nextLine();
                                           if (amount > 0) {
                                                boolean balance = bsi.transfer(cust.getAccountNo(), accNo, amount);
                                               if (balance == false) {
                                                   System.out.println("Account not found");
                                              } else if (balance == true) {
                                                  System.out.println("Insufficient Balance");
                                              } else {
                                                    System.out.println("Transfer Succesfully!\nYour new balance is: " + balance);
                                              }

                                          } else {
                                               System.out.println("Amount should be greater than 0");
                                          }

                                     } catch (NumberFormatException e) {
                                           System.out.println("Amount should be a number");
                                      }

                                        break;
                                        case "4":
                                        System.out.println("Balance: " + cust.getBalance());
                                        break;
                                    case "0":
                                        flag = false;
                                        break;
                                    //default:
                                       // System.out.println("Invalid choice");
                                }
                          //} else {
                            
                                //System.out.println("Your account is not active yet");
                          //  }
                        }
                        flag = true;
                  //  } else {
                       // System.out.println("Account No. or password is invalid");
                    }

                    break;

                case "2":
                    System.out.print("UserName: ");
                    String username = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();

                    match = false;
                    for (Employee emp : bsi.fetchAllEmployees()) {
                        if (emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
                            match = true;
                            empl = emp;
                            break;
                        }
                    }

                    if (match) {

                        while (flag) {
                            System.out.println("=========================");
                            System.out.println("Welcome " + empl.getUsername());
                            System.out.println("=========================");
                           // System.out.println("1: Approve Request");
                            System.out.println("2: Fetch Account Details");
                            System.out.println("3: List Customers");
                            System.out.println("0: Logout");
                            System.out.println("=========================");
                            System.out.print("Choice: ");
                            choice = input.nextLine();

                            switch (choice) {
                                case "1":
                                    /*if (!listRequest.isEmpty()) {
                                        System.out.println("---------------------------");
                                        System.out.println("No.   Name           Amount");
                                        System.out.println("---------------------------");
                                        for (int i = 0; i < listRequest.size(); i++) {
                                            System.out.println(String.format("%-6s", (i + 1))
                                                    + String.format("%-15s", listRequest.get(i).getName())
                                                    + String.format("%10s", listRequest.get(i).getBalance()));
                                        }
                                        System.out.println("---------------------------\n");

                                        System.out.print("Enter No. for approved: ");
                                        int no = input.nextInt();
                                        input.nextLine();
                                        if (no > 0 && no <= listRequest.size()) {
                                            int acc = bsi.createAccount(listRequest.get(no - 1));
                                            if (acc != -1) {
                                                System.out.println("Approved!" + "\nAccount No: " + acc);
                                            } else {
                                                System.out.println("Not Approved");
                                            }

                                        } else {
                                            System.out.println("Invalid No.");
                                        }

                                    } else {
                                        System.out.println("your account is added successfully"2);
                                    }
                                    break;*/
                                case "2":
                                    System.out.print("Enter Account No.:");
                                   int accNo = input.nextInt();
                                    input.nextLine();
                                    match = false;
                                    for (Customer c : bsi.fetchAllCustomers()) {
                                        if (c.getAccountNo() == accNo) {
                                            System.out.println(c.toString());
                                            match = true;
                                            break;
                                        }
                                    }

                                    if (!match) {
                                        System.out.println("Invalid Account No.");
                                    }

                                    break;
                                case "3":
                                    System.out.println("-------------------------------------------------------");
                                    System.out.println("Acc_No.   Name           Balance   Password    Status  ");
                                    System.out.println("-------------------------------------------------------");
                                    for (Customer c : bsi.fetchAllCustomers()) {
                                        System.out.println(String.format("%-10s", c.getAccountNo())
                                                + String.format("%-15s", c.getName()) + String.format("%-10s", c.getBalance())
                                                + String.format("%-12s", c.getPassword()) + String.format("%-8s", c.getStatus()));
                                    }
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case "0":
                                    flag = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }

                        }
                        flag = true;
                    } else {
                        System.out.println("UserName or password is invalid");
                    }

                    break;
                case "3":
                	Customer newCustomer = new Customer();
                    System.out.print("Enter your full name: ");
                    newCustomer.setName(input.nextLine());
                    System.out.print("Enter password: ");
                    newCustomer.setPassword(input.nextLine());
                    System.out.print("Enter amount you want to put in your account: ");
                    double amount;
                    while (true) {
                        try {
                            amount = input.nextDouble();
                            input.nextLine();
                            break;
                        } catch (NumberFormatException e)
                        {
                        	LOG.error(e);
                            System.out.println("Amount should be in integer");
                        }
                    }
                    newCustomer.setBalance(amount);
                    Customer addedCustomer;
					try {
						addedCustomer = bsi.createAccount(newCustomer);
						System.out.println("Customer Added Successfully!!\nYour new Account Nomber is " + addedCustomer.getAccountNo());
					} catch (SystemException e) {
						LOG.error(e);
						System.out.println(e.getMessage());
					}

                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
          
           
            }
       
        }
		
    }
}
