import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Withdrawal extends Banking
{
	public void Withdraw(double amount,long account_num)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from  Account where" + " Account_number = '"+account_num+"'  ");
			
			double bal=0;
			int c=0;
			while(res.next())
		    {
				c++;
		    	 bal= res.getDouble(3);
		    }
			if(c == 0)
			{
				System.out.print("Not a Valid Account number\n");
				return;
			}
			res.close();
			try
			{
				if(bal - amount < 0)
				{
					throw new Low_balance();
				}
				stmt.executeUpdate("Update Account set balance = balance - '"+amount+"' where" + " Account_number = '"+account_num+"'  ");
				 System.out.println("Amount Withdraw Successfully !!");
				ResultSet result = stmt.executeQuery("select * from  Account where" + " Account_number = '"+account_num+"'  ");
	     		
					while(result.next())
				    {
				    	
				    	System.out.println("Balance in Your Account : " + result.getDouble(3));
				    }
				
			  result.close();
			  stmt.close();
			}
			catch(Low_balance e)
			{
				System.out.println("Unable to Withdraw money !!! Balance is low !! first check balance and then try agian");
				System.out.println(e);
			}
			
//			if(bal - amount < 0)
//			{
//				System.out.println("Unable to Withdraw money !!! Balance is low !! first check balance and then try agian");
//				return;
//			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}
	}

