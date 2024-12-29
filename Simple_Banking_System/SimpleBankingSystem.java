package Simple_Banking_System;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBankingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accounts = new ArrayList<>();
		boolean running = true;
		
		System.out.println("Welcome to the SimpleBankingSystem.");
		
		while(running) {
			System.out.println("\nMenu");
			System.out.println("1. Create an Account.");
			System.out.println("2. Deposit Money.");
			System.out.println("3. Withdraw Money.");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice (1 - 5): ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1: //Create an Account.
				System.out.println("Enter an account holder's name: ");
				String name = scanner.nextLine();
				
				System.out.println("Enter an unique account number: ");
				String accountNumber = scanner.nextLine();
				
				//Check if account number is unique.
				boolean exists = accounts.stream().anyMatch(account -> account.getAccountNumber().equals(accountNumber));
				if(exists) {
					System.out.println("Account Number already exists. Please try again.");
				}
				else {
					accounts.add(new Account(name, accountNumber));
					System.out.println("Account created successfully for " + name);
				}
				break;
				
			case 2://deposit money
				System.out.println("Enter account number: ");
				String depositAccountNumber = scanner.nextLine();
				Account depositAccount = findAccount(accounts, depositAccountNumber);
				
				if(depositAccount != null) {
					System.out.println("Enter amount to deposit: ");
					double amount = scanner.nextDouble();
					depositAccount.deposit(amount);
				}
				else {
					System.out.println("Account not found.");
				}
				break;
				
			case 3: //Withdraw money
				System.out.println("Enter account number: ");
				String withdrawAccountNumber = scanner.nextLine();
				Account withdrawAccount = findAccount(accounts, withdrawAccountNumber);
				
				if(withdrawAccount != null) {
					System.out.println("Enter amount to withdraw: ");
					double amount = scanner.nextDouble();
					withdrawAccount.withdraw(amount);
				}
				else {
					System.out.println("Account not found.");
				}
				break;
				
			case 4://Check balance
				System.out.println("Enter account number: ");
				String balanceAccountNumber = scanner.nextLine();
				Account balanceAccount = findAccount(accounts, balanceAccountNumber);
				
				if(balanceAccount != null){
					System.out.println("Account Holder: " + balanceAccount.getAccountHolderName());
					System.out.println("Account Balance: $" + balanceAccount.getBalance());
				}
				else {
					System.out.println("Account not found");
				}
				break;
				
			case 5://Exit
				System.out.println("Thank you for using SimpleBankingSystem. Goodbye!");
				running = false;
				break;
			
			default:
				System.out.println("Invalid choice. Please try again!");
				break;
			}
		}
		scanner.close();
	}
	
	//Find an account by account number.
	private static Account findAccount(ArrayList<Account> accounts, String accountNumber) {
		for(Account account : accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	
}