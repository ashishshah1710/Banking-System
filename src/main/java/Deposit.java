import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deposit extends Banking
{
	public void deposit_money(double amount,long account_num)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from  Account where" + " Account_number = '"+account_num+"'  ");
			int c=0;
			while(result.next())
		    {
		    	c++;
		    	System.out.println("Balance in Your Account : " + result.getDouble(3));
		    }
			if(c == 0)
			{
				System.out.print("Not a Valid Account number\n\n");
				return;
			}
			stmt.executeUpdate("Update Account set balance = balance + '"+amount+"' where" + " Account_number = '"+account_num+"'  ");
		    System.out.println("Amount Deposit Successfully !!");
			 result = stmt.executeQuery("select * from  Account where" + " Account_number = '"+account_num+"'  ");
     		
				while(result.next())
			    {
			    	
			    	System.out.println("Balance in Your Account : " + result.getDouble(3));
			    }
				
			
		  result.close();
		  stmt.close();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}
}
