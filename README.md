# Bank Management System

This GitHub repository hosts a simple Bank Management System implemented in Java. The system allows the creation and management of customer accounts, checking and savings accounts, transactions, and various banking operations.

## Features

- **Customer Management**: Add customers with unique CNIC and manage their details.
- **Account Creation**: Open checking and savings accounts for customers with the ability to deposit, withdraw, and transfer funds.
- **Transaction Tracking**: Keep track of transactions, including date, amount, and remaining balance.
- **Account Types**: Differentiate between checking and savings accounts with specific functionalities.
- **Tax and Deductions**: Calculate and display tax, Zakat, and other deductions.

## Project Structure

- **Admin Class**: Manages customer-related operations, account transactions, and overall system functionalities.
- **Customer Class**: Represents a bank customer with details such as name, address, phone number, and CNIC.
- **Checking Class**: Represents a checking account with specific functionalities and deductions.
- **Savings Class**: Represents a savings account with interest rate calculations and deductions.
- **Account Class (Abstract)**: Base class for checking and savings accounts with common functionalities.
- **DatabaseHandler Class**: Handles database interactions, including customer and account information retrieval and insertion.
- **source Class (Main)**: Contains the main method and user interface for interacting with the bank management system.

## Database Setup

1. Create a MySQL database named `ACCOUNT`.
2. Use the database with the following tables:
   - `ACCOUNT`: Stores account information, including balance, account number, type, and owner CNIC.
   - `CUSTOMER`: Stores customer information, including name, address, phone number, and CNIC.

## How to Run

1. Compile and run the `source` class.
2. Follow the console prompts to interact with the Bank Management System.
3. Perform operations such as adding customers, opening accounts, making transactions, and displaying account information.

## Dependencies

- Java 8 or above.
- MySQL database.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/Moeez-Muslim/bank-management-system.git
   ```

2. Open the project in your preferred Java IDE.

3. Configure the MySQL database connection details in the `DatabaseHandler` class.

4. Run the `source` class to start the Bank Management System.

## Contribution Guidelines

Feel free to explore and enhance the code to meet specific requirements or add additional features. If you find bugs or have suggestions for improvement, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
