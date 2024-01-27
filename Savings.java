import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Savings extends Account
{
	private double ineterestRate = 1.1;
	
	// Constructor
	public Savings(double balance,  int accountNumber)
	{
		super(balance, accountNumber);
	}

	public double withdraw(double amount) 
	{
		if(amount > balance)
		{
			System.out.println("Not enough balance. Transaction UNSUCCESSFUL!");
			System.out.println("Balance: " + balance );
			return 0.0;
		}
		else
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
	}
	
	public double CalculateZakat()
	{
		if(this.balance >= 20000)
		{
			double temp = (this.balance*2.5)/100;
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
		else 
		{
			System.out.println("Zakat is not applicable on this account");
			return 0.0;
		}
	}

	public void DisplayAccount()
	{
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Balance: " + balance);
		System.out.println("Account Type: Savings Account");
	}
	
	public void ChangeIneterestRate(double rate)
	{
		this.ineterestRate = rate;
	}
	public double CalculateInterest()
	{
		return balance*ineterestRate;
	}
}
