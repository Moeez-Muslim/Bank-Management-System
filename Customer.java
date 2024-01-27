
public class Customer 
{
	private String Name;
	private String Address;
	private int phoneNumber;
	private int CNIC;
	public Savings SavingsAccount;
	public Checking CheckingAccount;
	
	public Customer()
	{
		SavingsAccount = null;
		CheckingAccount = null;
	}
	
	public Customer(String Name, String Address, int pNumber, int CNIC)
	{
		this.Name = Name;
		this.Address = Address;
		this.phoneNumber = pNumber;
		this.CNIC = CNIC;
		SavingsAccount = null;
		CheckingAccount = null;
	}
	
	public int getCNIC()
	{
		return CNIC;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void Print()
	{
		System.out.println("Name: " + this.Name);
		System.out.println("Address: " + this.Address);
		System.out.println("Phone Number: " + this.phoneNumber);
		System.out.println("CNIC: " + CNIC);
		if(CheckingAccount == null)
		{
			System.out.println("Checking Account Number: (No Account)");
		}
		else 
		{
			System.out.println("Checking Account Number: " + CheckingAccount.accountNumber);
		}
		
		if(SavingsAccount == null)
		{
			System.out.println("Savings Account Number: (No Account)");
		}
		else 
		{
			System.out.println("Savings Account Number: " + CheckingAccount.accountNumber);
		}
	}
	
	public boolean OpenAccount(double balance, int accountNumber, boolean checking)
	{
		if(checking)
		{
			if(CheckingAccount == null)
			{
				CheckingAccount = new Checking(balance, accountNumber);
				DatabaseHandler.createAccount(balance, accountNumber, "Checking", CNIC);
				return true;
			}
			else 
			{
				System.out.println("You can only have 1 checking account, which already exists. Account Number: " + CheckingAccount.accountNumber);
				return false;
			}
		}
		else 
		{
			if(SavingsAccount == null)
			{
				SavingsAccount = new Savings(balance, accountNumber);
				DatabaseHandler.createAccount(balance, accountNumber, "Savings", CNIC);
				return true;
			}
			else 
			{
				System.out.println("You can only have 1 savings account, which already exists. Account Number: " + SavingsAccount.accountNumber);
				return false;
			}
		}
	}
	
	public void CloseAccount(boolean checking)
	{
		if(checking)
		{
			CheckingAccount = null;
			System.out.println("Your checking account is closed");
		}
		else 
		{
			SavingsAccount = null;
			System.out.println("Your savings account is closed");
		}
	}
	
	public boolean LogIntoAccount(boolean checking)
	{
		if(checking)
		{
			if(CheckingAccount == null)
			{
				System.out.println(Name + " does not have a checking account");
				return false;
			}
			else 
			{
				System.out.println("Successfully Logged into " + Name + "'s Checking Account");
				return true;
			}
		}
		else 
		{
			if(SavingsAccount == null)
			{
				System.out.println(Name + " does not have a savings account");
				return false;
			}
			else 
			{
				System.out.println("Successfully Logged into " + Name + "'s savings Account");
				return true;
			}
		}
	}
	
	
}
