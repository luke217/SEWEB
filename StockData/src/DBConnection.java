import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;


public class DBConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	
	static final String USER = "root";
	static final String PASS = "";
	
	public static void connectDB() throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		
		Class.forName(JDBC_DRIVER);
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		stmt = conn.createStatement();
		
		String sqlQuery = "use stockdata;";
		stmt.executeUpdate(sqlQuery);
		sqlQuery = "insert into stockinfo values(1,'GOOGLE', 'GOOG');";
		stmt.executeUpdate(sqlQuery);
		stmt.close();
		conn.close();
	}
	
	@SuppressWarnings("deprecation")
	public static void insertData(int id, float price, Timestamp parsedData, int volume) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		
		Class.forName(JDBC_DRIVER);
		
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		stmt = conn.createStatement();
		String sqlQuery = "use stockdata;";
		stmt.executeUpdate(sqlQuery);
		stmt.close();
		
		PreparedStatement preparedStatement = conn.prepareStatement("insert into realtimedata values (?, ?, ?, ?)");
        preparedStatement.setInt(1, id);
		preparedStatement.setTimestamp(2, parsedData);
        preparedStatement.setFloat(3, price);
        preparedStatement.setInt(4, volume);
        preparedStatement.executeUpdate();
        
		conn.close();
	}
}
