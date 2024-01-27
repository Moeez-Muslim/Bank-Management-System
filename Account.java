import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public abstract class Account 
{
	// Constructor
	public Account(double balance, int accountNumber)  
	{
		this.balance = balance;
		dateCreatedDate = new Date();
		this.accountNumber = accountNumber;
	}
	
	// Variables
	protected double balance;
	Date dateCreatedDate;
	protected int accountNumber;
	LinkedList<String> Transactions = new LinkedList<String>();
	LinkedList<String> Deductions = new LinkedList<String>();

	// Methods
	public double checkBalance()
	{
		return balance;
	}
	
	
	
	public void printStatement(String CustomerName)
	{
		DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		
		System.out.println("\nCustomer Name: " + CustomerName);
		System.out.println("Account Number: " + this.accountNumber);
		System.out.println("Date Created: " + date_format_obj.format(dateCreatedDate));
		System.out.println("\nTransactions: ");
		
		if(Transactions.isEmpty())
		{
			System.out.println("\n(No Transactions)");
		}
		else 
		{
			for(int i = 0; i < Transactions.size();i++)
			{
				System.out.println(Transactions.get(i));
			}
		}
	}
	
	public void Deposit(double amount)
	{
		balance += amount;
		
		Date transactionDate = new Date();
		DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String T = new String();
		T += date_format_obj.format(transactionDate);
		T += "\tAmount: +";
		T += amount;
		T += "\tRemaining Balance: ";
		T += balance;
		
		Transactions.add(T);
		
		System.out.println("Amount deposited: " + amount);
		System.out.println("Balance: " + balance);
		System.out.println("Transaction Fee: 0.0");
	}
	
	
	public boolean Transfer(double amount)
	{
		if(amount > balance)
		{
			System.out.println("Insufficient funds");
			return false;
		}
		else 
		{
			balance = balance - amount;
			
			Date transactionDate = new Date();
			DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			String T = new String();
			T += date_format_obj.format(transactionDate);
			T += "\tAmount: -";
			T += amount;
			T += "\tRemaining Balance: ";
			T += balance;
			
			Transactions.add(T);
			
			
			System.out.println("Amount Transfered: " + amount);
			System.out.println("Remaining Balance: " + this.balance);
			
			return true;
		}
	}
	abstract double withdraw(double amount);
	
	void displayDeductions(String CustomerName)
	{
		DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		
		System.out.println("\nCustomer Name: " + CustomerName);
		System.out.println("Account Number: " + this.accountNumber);
		System.out.println("Date Created: " + date_format_obj.format(dateCreatedDate));
		System.out.println("\nDeductions: ");
		
		if(Deductions.isEmpty())
		{
			System.out.println("\n(No Deductions)");
		}
		else 
		{
			for(int i = 0; i < Deductions.size();i++)
			{
				System.out.println(Deductions.get(i));
			}
		}
	}
		
}
