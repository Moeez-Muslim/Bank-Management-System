import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatabaseHandler
{
	public static LinkedList<Customer> loadCustomersFromDatabase() 
	{
        LinkedList<Customer> customers = new LinkedList<Customer>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/Account";
        String username = "root";
        String password = "&Ronaldo7";

        try 
        {
            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String selectQuery = "SELECT * FROM CUSTOMER";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) 
            {
                String name = resultSet.getString("NAME");
                String address = resultSet.getString("ADRESS");
                int phoneNo = resultSet.getInt("PHONE_NO");
                int cnic = resultSet.getInt("CNIC");

                // Create a new Customer object and add it to the list
                customers.add(new Customer(name, address, phoneNo, cnic));
            }

            // Close the resources
            resultSet.close();
            selectStatement.close();
            connection.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return customers;
    }
	
	public static void InsertCustomer(String Name, String Address, int Phone_No, int CNIC)
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/Account";
        String username = "root";
        String password = "&Ronaldo7";

        try 
        {
            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            String insertQuery = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, Name); // Set the first placeholder to Name
            insertStatement.setString(2, Address); // Set the second placeholder to Address
            insertStatement.setInt(3, Phone_No); // Set the third placeholder to Phone_No
            insertStatement.setInt(4, CNIC); // Set the fourth placeholder to CNIC
            
            int rowsInserted = insertStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
         
            insertStatement.close();
            connection.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	public static void createAccount(double balance, int accountNumber, String type, int ownerCNIC) 
	{
        String jdbcUrl = "jdbc:mysql://localhost:3306/Account";
        String username = "root";
        String password = "&Ronaldo7";

        try 
        {
            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "INSERT INTO ACCOUNT (BALANCE, ACCOUNT_NUMBER, TYPE, OWNER_CNIC) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setDouble(1, balance);
            insertStatement.setInt(2, accountNumber);
            insertStatement.setString(3, type);
            insertStatement.setInt(4, ownerCNIC);

            int rowsInserted = insertStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // Close the resources
            insertStatement.close();
            connection.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
	
	public static void DisplayCustomer(int CNIC)
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/Account";
        String username = "root";
        String password = "&Ronaldo7";

        try 
        {
            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            String selectQuery = "SELECT* FROM CUSTOMER WHERE CUSTOMER.CNIC = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, CNIC); // Set the first placeholder to Name
            
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) 
            {
                String name = resultSet.getString("NAME"); // Make sure to use the correct column names
                String address = resultSet.getString("ADRESS");
                String phoneNo = resultSet.getString("PHONE_NO");
                int cnic = resultSet.getInt("CNIC");

                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Phone No: " + phoneNo);
                System.out.println("CNIC: " + cnic);
                System.out.println("\n------------------------");
            }

            // Close the resources
            resultSet.close();
            selectStatement.close();
            connection.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
}
