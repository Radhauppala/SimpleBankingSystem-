package Simple_Banking_System;

public class Account {

		private String accountHolderName;
		private String accountNumber;
		private double balance;
		
		public Account(String accountHolderName, String accountNumber) {
			this.accountHolderName = accountHolderName;
			this.accountNumber = accountNumber;
			this.balance = 0.0;
		}
		
		public String getAccountHolderName() {
			return accountHolderName;
		}
		
		public String getAccountNumber() {
			return accountNumber;
		}
		
		public double getBalance() {
			return balance;
		}
		
		//Method for deposit amount
		public void deposit(double amount) {
			if(amount > 0) {
				balance += amount;
				System.out.println("Successfully deposited: $" + amount);
			}
			else {
				System.out.println("Deposit amount must be positive: $" + amount);
			}
		}
				
				
		//Method for withdraw amount
		public void withdraw(double amount) {
			if(amount > 0 && amount <= balance) {
				balance -= amount;
				System.out.println("Successfully withdrew: $" + amount);
			}
			else if(amount > balance) {
				System.out.println("Insufficient balance.");
			}
			else {
				System.out.println("Withdrawal amount must be positive.");
			}
		}
		
}

