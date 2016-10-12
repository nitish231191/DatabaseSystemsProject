package dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DML {

	private final String dbURL = "jdbc:mysql://database-new.cse.tamu.edu/ujraaja";
	private final String username = "ujraaja";
	private final String password = "raaja";
	private Connection conn = null;
	private Statement statement = null;

	private HashMap<String, String[]> attributes = new HashMap<>();
	
	public DML() throws ClassNotFoundException, SQLException {
		createConnection();
		populateAttributes();
	}
	
	private void populateAttributes() {
		String[] attrs = {"UID", "Name", "Designation", "Contact"};
		attributes.put("People", attrs);
		
		String[] attr1 = {"ISBN", "UID", "BorrowedDate", "DueDate"};
		attributes.put("Borrowers", attr1);
		
		String[] attr2 = {"Name", "Author", "ISBN", "IsAvailable"};
		attributes.put("Books", attr2);
		
		String[] attr3 = {"UIN", "Name", "Phone", "Dt"};
		attributes.put("test", attr3);
	}
	
	private void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbURL, username, password);
		statement = conn.createStatement();
	}
	
	public boolean create(String tableName, String[] values) throws SQLException {
		String query = "INSERT INTO " + tableName + " VALUES(";
		for(int i = 0; i < values.length; i++)
			if(i == 0) query += "\"" + values[i] + "\"";
			else query += ", " + "\"" + values[i] + "\"";
		query += ")";
		System.out.println("Executing: " + query);
		return statement.executeUpdate(query) != 0;
	}
	
	public ResultSet read(String tableName, String[] values) throws SQLException {
		String query = "SELECT * FROM " + tableName;
		String[] attrs = attributes.get(tableName);
		if(tableName.equals("Borrowers"))
			query += " NATURAL JOIN People NATURAL JOIN Books";
		String attrString = "";
		for(int i = 0; i < values.length; i++)
			if(!values[i].isEmpty())
				if(attrString.isEmpty()) attrString = attrs[i] + "=\"" + values[i] + "\"";
				else attrString += " AND " + attrs[i] + "=\"" + values[i] + "\"";
		if(!attrString.isEmpty()) {
			if(tableName.equals("Borrowers"))
				attrString = "Borrowers." + attrString.replace(" AND ", " AND Borrowers.");
			query += " WHERE " + attrString;
		}
		System.out.println("Executing: " + query);
		return statement.executeQuery(query);
	}
	
	public ResultSet executeRead(String query) throws SQLException {
		System.out.println("Executing: " + query);
		return statement.executeQuery(query);
	}

	public boolean update(String tableName, String[] values, String[] newValues) throws SQLException {
		String query = "UPDATE " + tableName + " SET ";
		String[] attrs = attributes.get(tableName);
		for(int i = 0; i < newValues.length; i++)
			if(i == 0) query += attrs[i] + "=\"" + newValues[i] + "\"";
			else query += ", " + attrs[i] + "=\"" + newValues[i] + "\"";
		query += " WHERE ";
		for(int i = 0; i < values.length; i++)
			if(i == 0) query += attrs[i] + "=\"" + values[i] + "\"";
			else query += " AND " + attrs[i] + "=\"" + values[i] + "\"";
		System.out.println("Executing: " + query);
		return statement.executeUpdate(query) != 0;
	}

	public boolean delete(String tableName, String[] values) throws SQLException {
		String query = "DELETE FROM " + tableName + " WHERE ";
		String[] attrs = attributes.get(tableName);
		for(int i = 0; i < values.length; i++)
			if(i == 0) query += attrs[i] + "=\"" + values[i] + "\"";
			else query += " AND " + attrs[i] + "=\"" + values[i] + "\"";
		System.out.println("Executing: " + query);
		return statement.executeUpdate(query) != 0;
	}
	
	public void closeConnections() throws SQLException {
		statement.close();
		conn.close();
	}
	
	public void createTable() throws SQLException {
		String query = "CREATE TABLE Borrowers (ISBN VARCHAR(20) NOT NULL, UID BIGINT(12) NOT NULL, BorrowedDate CHAR(10), DueDate CHAR(10), FOREIGN KEY (ISBN) REFERENCES Books(ISBN), FOREIGN KEY (UID) REFERENCES People(UID))";
		//String query = "CREATE TABLE People (UID BIGINT(12) NOT NULL, Name VARCHAR(40), Designation VARCHAR(20), Contact VARCHAR(20), PRIMARY KEY (UID))";
		//String query = "CREATE TABLE Books (Name VARCHAR(40), Author VARCHAR(50), ISBN VARCHAR(20) NOT NULL, IsAvailable VARCHAR(5), PRIMARY KEY (ISBN))";
		System.out.println("Executing: " + query);
		statement.execute(query);
	}
}
