import java.util.LinkedList;

public class Admin 
{
	public Customer currentCustomer;
	
	private LinkedList<Customer> Customers = new LinkedList<Customer>();
	
	public Admin()
	{
		currentCustomer = null;
		Customers = DatabaseHandler.loadCustomersFromDatabase();  // Loading Customers from database
	}
	
	public void AddCustomer(String Name, String Address, int phoneNumber, int CNIC)
	{
		Customer temp = new Customer(Name, Address, phoneNumber, CNIC);
		for(Customer C : Customers)
		{
			if(C.getCNIC() == CNIC)
			{
				System.out.println("This CNIC is already registered. Cutomer creation failed!");
				return;
			}
		}
		
		Customers.add(temp);
		DatabaseHandler.InsertCustomer(Name, Address, phoneNumber, CNIC);  // Inserting Customer in Database
		temp = null;

		System.out.println("Customer Added Successfully!"); 
	}
	
	public boolean LogIntoCustomer(int CNIC)
	{
		if(Customers.isEmpty())
		{
			System.out.println("No Customers Exist");
			return false;
		}
		
		boolean found = false;
		for(int i = 0;i < Customers.size(); i++)
		{
			if(Customers.get(i).getCNIC() == CNIC)
			{
				currentCustomer = Customers.get(i);
				found = true;
				System.out.println("Logged IN successfully!");
				System.out.println("Profile Name: " + currentCustomer.getName());
				return true;
			}
		}
		
		if(!found)
		{
			System.out.println("Customer not found!");
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	private int FindCheckingAccount(int accNumber)
	{
		if(Customers.isEmpty())
		{
			return -1;
		}
		
		for(int i = 0; i < Customers.size();i++)
		{
			if(Customers.get(i).CheckingAccount != null)
			{
				if(accNumber == Customers.get(i).CheckingAccount.accountNumber)
				{
					return  i;
				}
			}
		}
		
		return -1;
	}
	
	private int FindSavingsAccount(int accNumber)
	{
		if(Customers.isEmpty())
		{
			return -1;
		}
		
		for(int i = 0; i < Customers.size();i++)
		{
			if(Customers.get(i).SavingsAccount != null)
			{
				if(accNumber == Customers.get(i).SavingsAccount.accountNumber)
				{
					return  i;
				}
			}
		}
		
		return -1;
	}
	
	
	public boolean TransferAmount(double amount, int transferFromACC, int transferToACC, boolean fromChecking)
	{
		System.out.println("-----------------------");
		System.out.println("Amount: " + amount);
		System.out.println("From: " + transferFromACC);
		System.out.println("To: " + transferToACC);
		System.out.println("From Checking: " + fromChecking);
		System.out.println("-----------------------");
		
		Account beneficiary;
		int toIndex = FindCheckingAccount(transferToACC);
		
		if(toIndex == -1)
		{
			toIndex = FindSavingsAccount(transferToACC);
			if(toIndex == -1)
			{
				System.out.println("Beneficiary Host Link not available");
				return false;
			}
			else 
			{
				beneficiary = Customers.get(toIndex).SavingsAccount;
			}
			
		}
		else 
		{
			beneficiary = Customers.get(toIndex).CheckingAccount;
		}
		
		
		if(fromChecking)
		{
			int fromIndex = FindCheckingAccount(transferFromACC);
			if(Customers.get(fromIndex).CheckingAccount.Transfer(amount))
			{
				System.out.println("\n--- Beneficiary View ---\n");
				beneficiary.Deposit(amount);
				return true;
			}
			else 
			{
				return false;
			}
		}
		else 
		{
			int fromIndex = FindSavingsAccount(transferFromACC);
			if(Customers.get(fromIndex).SavingsAccount.Transfer(amount))
			{
				System.out.println("Beneficiary View: ");
				beneficiary.Deposit(amount);
				return true;
			}
			else 
			{
				return false;
			}
		}
	}
	
	public void DisplayAllAccounts()
	{
		System.out.println("Bank Owner: Moeez Muslim\n");
		for(int i =0;i<Customers.size();i++)
		{
			System.out.println("Customer Name: " + Customers.get(i).getName());
			if(Customers.get(i).CheckingAccount != null)
			{
				System.out.println("=============================");
				Customers.get(i).CheckingAccount.DisplayAccount();
			}
			else 
			{
				System.out.println("=============================");
				System.out.println("Checking Account: (No Account)");
			}
			
			if(Customers.get(i).SavingsAccount != null)
			{
				System.out.println("=============================");
				Customers.get(i).SavingsAccount.DisplayAccount();
			}
			else 
			{
				System.out.println("=============================");
				System.out.println("Savings Account: (No Account)");
			}
			
			System.out.println("\n------------------------------\n");
		}
	}
	
	public void DisplayAllAccountDeductions()
	{
		for(int i =0;i<Customers.size();i++)
		{
			System.out.println("Customer Name: " + Customers.get(i).getName());
			if(Customers.get(i).CheckingAccount != null)
			{
				System.out.println("=============================");
				Customers.get(i).CheckingAccount.displayDeductions(Customers.get(i).getName());
			}
			else 
			{
				System.out.println("=============================");
				System.out.println("Checking Account: (No Account)");
			}
			
			if(Customers.get(i).SavingsAccount != null)
			{
				System.out.println("=============================");
				Customers.get(i).SavingsAccount.displayDeductions(Customers.get(i).getName());
			}
			else 
			{
				System.out.println("=============================");
				System.out.println("Savings Account: (No Account)");
			}
			
			System.out.println("\n------------------------------\n");
		}
	}
	
	
}
