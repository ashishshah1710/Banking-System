import java.util.*;

public class Main {

	@SuppressWarnings("resource")
	public static void show_menu()
	{
		int option=1;
		Scanner sc=new Scanner(System.in);
		
		while(option != 5)
		{
		System.out.println("1.Open a new Account");
		System.out.println("2.Check Balance");
		System.out.println("3.Withdrawal");
		System.out.println("4.Deposite");
		System.out.println("5.Exit");
		
		
		System.out.println("Press the Above keys for further operation : ");
	    option=sc.nextInt();
		
		switch(option)
		{
		
		case 1: Open_Accont a = new Open_Accont();
				System.out.println("Account number : " + a.account_open() + "  Save the number for Future");
				break;
		case 2: Check_balance b=new Check_balance();
				System.out.println("Enter your Account Number for Balance Check ");
				long aa=sc.nextLong();
				double acc=b.balance(aa);
				if(acc == Double.MIN_VALUE)
					System.out.println("Invalid Account Number");
				else
				    System.out.println("Balance in Account number " + aa + " is : " + b.balance(aa));
				break;
		case 3 :Withdrawal w=new Withdrawal();
		        System.out.println("Enter your Account Number ");
				long accc_num =sc.nextLong();
				System.out.println("Enter Amount to withdraw  ");
				double amount=sc.nextDouble();
				w.Withdraw(amount, accc_num);
				break;
		case 4 : Deposit d=new Deposit();
		 		System.out.println("Enter your Account Number ");
		 		long acccc_num =sc.nextLong();
			    System.out.println("Enter Amount to Deposit  ");
			    double amountt=sc.nextDouble();
			    d.deposit_money(amountt, acccc_num);
			    break;
		
		default : System.out.println("Invalid Choice");
				  break;
		case 5  :System.out.println("Thankyou for using Banking Service") ;break;
		}
		}
	}
	public static void main(String[] args) throws ExitException
	{
	
		int i=1;
		Scanner s=new Scanner (System.in);
		show_menu();
		/*while(true)
		{
		 show_menu();
		 System.out.print("Press 1 for continue 0 for exit");
		 i=s.nextInt();
		 try {
		 if(i == 0)
		 {
			 throw new Exception();
		 }}
		 catch(Exception e )
		 {
			 System.out.print("Program Ends" + e);
		 }
		}
		*/
		
		
	}

}
