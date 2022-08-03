import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.Scanner;

public class Open_Accont extends Banking
{

	public Open_Accont() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name : ");
		name=sc.nextLine();
		System.out.println("Enter Email id : ");
		gmail=sc.nextLine();
		System.out.println("Enter you mobile : ");
		mobile=sc.nextLong();
		balance=0;
		account_no=0;
		System.out.println("Account opening in Progress");
		sc.close();
	}
	public long account_open()
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userName = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			Statement stmt = con.createStatement();
			
			String sql="insert into Account (Name,balance,Email_id,Mobile_number) values ('"+name+"','"+balance+"','"+gmail+"','"+mobile+"')";
			stmt.executeUpdate(sql);
			//stmt.executeQuery(sql);
			System.out.println("!! Account Created Successfully !!");
			
			ResultSet result = stmt.executeQuery("select Account_number,balance from  Account where Name='"+name+"'  ");
			
			
			
		    while(result.next())
		    {
		    	account_no=result.getLong("Account_number");
		    }
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account_no;
	}
	}

	

