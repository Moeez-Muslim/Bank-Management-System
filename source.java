import java.util.*;

public class source 
{
	
	public static void main(String[] args) 
	{
		//DatabaseHandler.InsertCustomer("Zaid", "P-102", 0316, 33100);

		int AccountNumber = 123;
		Admin admin = new Admin();
		// create an object of Scanner
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Add Customer");
			System.out.println("2. Log into Customer Profile");
			System.out.println("3. Display All Accounts");
			System.out.println("4. Display All Deductions");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");
			int choice1 = input.nextInt();

			if (choice1 == 1) {
				System.out.print("\nEnter Customer's Name: ");
				String Name = input.next();
				System.out.print("Enter Customer's Address: ");
				String Address = input.next();
				System.out.print("Enter Customer's Phone Number: ");
				int phoneNumber = input.nextInt();
				System.out.print("Enter Customer's CNIC: ");
				int CNIC = input.nextInt();
				admin.AddCustomer(Name, Address, phoneNumber, CNIC);
			} else if (choice1 == 2) {
				System.out.print("\nEnter Customer's CNIC: ");
				int CNIC = input.nextInt();

				if (admin.LogIntoCustomer(CNIC)) {
					while (true) // If log in is successful
					{
						System.out.println("\n1. Open Account");
						System.out.println("2. Close Account");
						System.out.println("3. Log into account");
						System.out.println("4. Go Back");
						System.out.print("Enter choice: ");
						int choice2 = input.nextInt();

						if (choice2 == 1) 
						{
							System.out.print("\nEnter opening balance: ");
							double balance = input.nextDouble();
							System.out.println("1. Checking Account");
							System.out.println("2. Savings Account");
							System.out.print("Enter choice: ");
							int choice3 = input.nextInt();

							if (choice3 == 1) 
							{
								if(admin.currentCustomer.OpenAccount(balance, AccountNumber, true))
								{
									System.out.println("Assigned Account Number: " + AccountNumber++);
								}
							} 
							else if (choice3 == 2) 
							{
								if(admin.currentCustomer.OpenAccount(balance, AccountNumber, false))
								{
									System.out.println("Assigned Account Number: " + AccountNumber++);
								}
							} 
							else 
							{
								System.out.print("Invalid Choice");
							}
						} 
						else if (choice2 == 2) 
						{
							System.out.println("\n1. Checking Account");
							System.out.println("2. Savings Account");
							System.out.print("Enter choice: ");
							int choice3 = input.nextInt();

							if (choice3 == 1) {
								admin.currentCustomer.CloseAccount(true);
							} else if (choice3 == 2) {
								admin.currentCustomer.CloseAccount(false);
							} else {
								System.out.print("Invalid Choice");
							}
						} 
						else if (choice2 == 3) 
						{
							System.out.println("\n1. Checking Account");
							System.out.println("2. Savings Account");
							System.out.print("Enter choice: ");
							int choice3 = input.nextInt();

							if (choice3 == 1) {
								if (admin.currentCustomer.LogIntoAccount(true)) {
									// Third while loop for account menu
									while (true) {
										System.out.println("\n1. Deposit");
										System.out.println("2. Withdraw");
										System.out.println("3. Check Balance");
										System.out.println("4. Print Statement");
										System.out.println("5. Bank Transfer");
										System.out.println("6. Display Tax & Fee Decutions");
										System.out.println("7. Calculate Tax");
										System.out.println("8. Go Back");
										System.out.print("Enter choice: ");
										int choice4 = input.nextInt();

										if (choice4 == 1) {
											System.out.print("Enter amount to deposit: ");
											double amount = input.nextDouble();
											admin.currentCustomer.CheckingAccount.Deposit(amount);
										} else if (choice4 == 2) {
											System.out.print("Enter amount to wwithdraw: ");
											double amount = input.nextDouble();
											admin.currentCustomer.CheckingAccount.withdraw(amount);
										} else if (choice4 == 3) {
											System.out.println("Your balance is: "
													+ admin.currentCustomer.CheckingAccount.checkBalance());
										} else if (choice4 == 4) {
											admin.currentCustomer.CheckingAccount.printStatement(admin.currentCustomer.getName());

										} else if (choice4 == 5) {
											System.out.print("Enter amount to transfer: ");
											double amount = input.nextDouble();
											System.out.print("Enter account number to transfer to: ");
											int toACC = input.nextInt();
											admin.TransferAmount(amount,
													admin.currentCustomer.CheckingAccount.accountNumber, toACC, true);
										} else if (choice4 == 6) {
											admin.currentCustomer.CheckingAccount.displayDeductions(admin.currentCustomer.getName());

										} else if (choice4 == 7) {
											System.out.println("Your have to paid "
													+ admin.currentCustomer.CheckingAccount.CalculateTax()
													+ " in Taxes");
										} else {
											break;
										}

									}

								}

							}

							else if (choice3 == 2) {
								if (admin.currentCustomer.LogIntoAccount(false)) {
									// Third while loop for account menu
									while (true) {
										System.out.println("\n1. Deposit");
										System.out.println("2. Withdraw");
										System.out.println("3. Check Balance");
										System.out.println("4. Print Statement");
										System.out.println("5. Bank Transfer");
										System.out.println("6. Display Zakat Decutions");
										System.out.println("7. Calculate Zakat");
										System.out.println("8. Change interest rate");
										System.out.println("9. Go Back");
										System.out.print("Enter choice: ");
										int choice4 = input.nextInt();

										if (choice4 == 1) {
											System.out.print("Enter amount to deposit: ");
											double amount = input.nextDouble();
											admin.currentCustomer.SavingsAccount.Deposit(amount);
										} else if (choice4 == 2) {
											System.out.print("Enter amount to wwithdraw: ");
											double amount = input.nextDouble();
											admin.currentCustomer.SavingsAccount.withdraw(amount);
										} else if (choice4 == 3) {
											System.out.println("Your balance is: "
													+ admin.currentCustomer.SavingsAccount.checkBalance());
										} else if (choice4 == 4) {
											admin.currentCustomer.SavingsAccount.printStatement(admin.currentCustomer.getName());

										} else if (choice4 == 5) {
											System.out.print("Enter amount to transfer: ");
											double amount = input.nextDouble();
											System.out.print("Enter account number to transfer to: ");
											int toACC = input.nextInt();
											if(admin.TransferAmount(amount, admin.currentCustomer.SavingsAccount.accountNumber, toACC, false))
											{
												System.out.println("Transaction Successful!");
											}
											else 
											{
												System.out.println("Transaction Failed!");
											}
										} else if (choice4 == 6) {
											admin.currentCustomer.SavingsAccount.displayDeductions(admin.currentCustomer.getName());
									
										} else if (choice4 == 7) {
											System.out.println("Your have to pay "
													+ admin.currentCustomer.SavingsAccount.CalculateZakat()
													+ " in Zakat");
										} else if (choice4 == 8) {
											System.out.print("Enter new interest rate: ");
											double rate = input.nextDouble();
											admin.currentCustomer.SavingsAccount.ChangeIneterestRate(rate);
											System.out.println("Ineterst Changed to: " + rate);
										}
										else {
											break;
										}
									}

								}
							} else {
								System.out.print("Invalid Choice");
							}
						} else {
							break;
						}
					} // if
				} // while
			} 
			else if (choice1 == 3) 
			{
				admin.DisplayAllAccounts();
				
			} 
			else if (choice1 == 4) 
			{
				admin.DisplayAllAccountDeductions();
				
			} 
			else 
			{
				// Closing the scanner object
				input.close();
				return;
			}
		}
	}

}
