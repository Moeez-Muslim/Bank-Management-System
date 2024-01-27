import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Checking extends Account
{
	// Constructor
	public Checking(double balance, int accountNumber)
	{
		super(balance, accountNumber);
		freeTransactions = 2;
	}

	// Variables
	private int freeTransactions;	
	

	
	public double withdraw(double amount)
	{
		// customer can withdraw 5000 more than their balance
		if((balance-amount) > -5000)
		{
			balance -= amount;
			
			Date transactionDate = new Date();
			DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			String T = new String();
			T += date_format_obj.format(transactionDate);
			T += "\tAmount: -";
			T += amount;
			T += "\tRemaining Balance: ";
			T += balance;
			
			Transactions.add(T);
			
			System.out.println("Amount withdrawn: " + amount );
			System.out.println("Remaining Balance: " + balance );
			return amount;
		}
		else
		{
			System.out.println("Your account deficit cannot increasse PKR 5000. Withdrawal Unsuccessful!");
			return 0.0;		
		}
	}
	
	public void DisplayAccount()
	{
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Balance: " + balance);
		System.out.println("Account Type: Checking Account");
	}

	public void Deposit(double amount)
	{
		if(freeTransactions > 0)
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
			
			freeTransactions--;
			System.out.println("Amount deposited: " + amount);
			System.out.println("Balance: " + balance);
			System.out.println("Transaction Fee: 0.0");
		}
		else 
		{
			balance += amount;
			balance -= 10;
			
			Date transactionDate = new Date();
			DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			String T = new String();
			T += date_format_obj.format(transactionDate);
			T += "\tAmount: +";
			T += amount;
			T += "\tRemaining Balance: ";
			T += balance;
			
			Transactions.add(T);
			
			String T1 = new String();
			T1 += date_format_obj.format(transactionDate);
			T1 += "\tFee: -";
			T1 += 10;
			T1 += "\tRemaining Balance: ";
			T1 += balance;
			
			Deductions.add(T1);
			
			System.out.println("Amount deposited: " + amount);
			System.out.println("Balance: " + balance);
			System.out.println("Transaction Fee: 10.0");
		}
		
	}
	
	
	public double CalculateTax()
	{
		double temp = this.balance*0.1;
		balance = balance - temp;
		
		Date transactionDate = new Date();
		DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String T = new String();
		T += date_format_obj.format(transactionDate);
		T += "\tAmount: +";
		T += temp;
		T += "\tRemaining Balance: ";
		T += balance;
		
		Deductions.add(T);
		
		return temp;
	}
	
	
	
}
