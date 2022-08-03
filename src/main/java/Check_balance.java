import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Check_balance extends Banking
{
	public double balance(long account_num)
	{
		balance=Double.MIN_VALUE;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			
		
			ResultSet result = stmt.executeQuery("select * from  Account where" + " Account_number = '"+account_num+"'  ");
//			ResultSet result = stmt.executeQuery("select * from  Account ");
			
				while(result.next())
			    {
			    	balance=result.getDouble(3);
			    	
			    }
			
		  result.close();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
		
	}
	
}
