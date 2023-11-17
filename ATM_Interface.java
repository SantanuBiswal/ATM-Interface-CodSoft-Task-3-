import java.util.*;

class BankAccount {
	private double balance;

    	public BankAccount(double initialBalance) {
        	this.balance = initialBalance;
    	}

    	public double getBalance() {
        	return balance;
    	}

    	public void deposit(double amount) {
        	balance += amount;
    	}

    	public boolean withdraw(double amount) {
        	if (amount <= balance) {
            		balance -= amount;
            		return true;
        	} 
		else {
            		return false;
        	}
    	}
}

class ATM {
    	private BankAccount account;
	Scanner s=new Scanner(System.in);
    	public ATM(BankAccount account) {
        	this.account = account;
    	}

    	public void displayOptions() {
        	System.out.println("\t\t\tATM Menu:");
		System.out.println("\t\t--------------------------");
        	System.out.println("\t\t1. Check Balance");
        	System.out.println("\t\t2. Deposit");
        	System.out.println("\t\t3. Withdraw");
        	System.out.println("\t\t4. Exit");   
    	}

    	public void performTransaction(int option) {
        	switch (option) {
            		case 1:
                		System.out.println(">>> Your balance: $" + account.getBalance());
                		break;
            		case 2:
				System.out.print("Enter the amount: $");
				double amount = s.nextDouble();
                		account.deposit(amount);
                		System.out.println(">>> Deposited $" + amount);
                		break;
            		case 3:
				System.out.print("Enter the amount: $");
				double ammount = s.nextDouble();
                		boolean success = account.withdraw(ammount);
                		if (success) {
                    			System.out.println(">>> Withdrawn $" + ammount);
                		} 
				else {
                    			System.out.println(">>> Oops!! Insufficient balance for withdrawal.");
                		}
                		break;
            		case 4:
                		System.out.println("!!! Thank you for using the ATM. !!!");
                		System.exit(0);
                		break;
            		default:
                		System.out.println("Invalid option. Please select a valid option.");
        	}
    	}
}

 class ATM_Interface {
    	public static void main(String[] args) {
        	BankAccount userAccount = new BankAccount(5000.0);
        	ATM atm = new ATM(userAccount);

        	Scanner scanner = new Scanner(System.in);
		String ch;
        	do {
        		atm.displayOptions();
         		System.out.print("\nEnter your choice: ");
         		int choice = scanner.nextInt();

         		if (choice == 4) {
 				atm.performTransaction(choice);
               			// scanner.close();
                		//break;
            		}

            		if (choice >= 1 && choice <= 3) {
               			// System.out.print("Enter the amount: $");
                		//double amount = scanner.nextDouble();
                		atm.performTransaction(choice);
            		}	 
			else {
                		System.out.println("Invalid option. Please select a valid option.");
            		}
		
			System.out.print("\nDo You want to used again . Please press (y/Y) : ");
			Scanner st=new Scanner(System.in);
			ch=st.nextLine();
           	}

		while(ch.equals("y") || ch.equals("Y"));
    	}
}