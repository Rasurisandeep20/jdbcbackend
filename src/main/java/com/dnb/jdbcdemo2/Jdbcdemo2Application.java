package com.dnb.jdbcdemo2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.exception.IdNotFoundException;
import com.dnb.jdbcdemo2.service.AccountService;
import com.dnb.jdbcdemo2.service.CustomerService;

 

@SpringBootApplication // component scan, properties source
public class Jdbcdemo2Application {


	static AccountService accountService;
	static CustomerService customerService;
	public static void main(String[] args) {
		// creates application context object
		ApplicationContext applicationContext = SpringApplication.run(Jdbcdemo2Application.class, args);
		accountService = applicationContext.getBean(AccountService.class); 
		customerService = applicationContext.getBean(CustomerService.class);
		Scanner scan = new Scanner(System.in);
//		System.out.println("enter account details:");
//		//System.out.println("Enter accountId:");
//		//String accountId = scan.next();
//		System.out.println("Enter Name:");
//		String name = scan.next();
//		System.out.println("Enter AccountType:");
//		String accountType = scan.next();
//		System.out.println("Enter Balance:");
//		float balance = scan.nextFloat();
//		System.out.println("Enter contact Number:");
//		String contact = scan.next();
//		System.out.println("Enter Address:");
//		String address = scan.next();
//		System.out.println("Enter Date of birth in format DD/MM/YYYY:");
//		String date = scan.next();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate localDate = LocalDate.parse(date, formatter);
//		try {
//			Customer customer = new Customer(1009, "Charls Darwin", "6547389210", "Hyderabad", "TYRUEIWOQP", "YTURIEOWPQ");
//			Account account = new Account();
//			account.setAccountHolderName(name);
//			account.setAccountStatus(true);
//			account.setAccountType(accountType);
//			account.setAddress(address);
//			account.setBalance(balance);
//			account.setContactNumber(contact);
//			account.setDob(localDate);
//
//			System.out.println(accountService.createAccount(account));
//		} catch (IdNotFoundException e) {
//			System.out.println(e);
//		} catch (InvalidNameException e) {
//			e.printStackTrace();
//		} catch (InvalidDateException e) {
//			e.printStackTrace();
//		} catch (InvalidContactNumberException e) {
//			e.printStackTrace();
//		}
//		System.exit(0);;
		//applicationContext.getBean(AccountService.class).getAllAccounts().forEach(e->System.out.println(e));
		//Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("1.CreateAccount\n2.Get Account\n3.Get All Accounts\n4.delete account\n5.exit");
			System.out.println("Enter option:");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				createAccount();
				break;
			case 2:
				getAccount();
				break;
//			case 3:
//				getAllAccounts();
//				break;
//			case 4:
//				deleteAccount();
//				break;
			case 3:
				scan.close();
				System.exit(0);
			default:
				System.out.println("Wrong choice");
				System.out.println("Choose again..");
				break;
			}
		}
	}

 

	public static void createAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter account details:");
		//System.out.println("Enter accountId:");
		//String accountId = scan.next();
		System.out.println("Enter Name:");
		String name = scan.next();
		System.out.println("Enter AccountType:");
		String accountType = scan.next();
		System.out.println("Enter Balance:");
		float balance = scan.nextFloat();
		System.out.println("Enter contact Number:");
		String contact = scan.next();
		System.out.println("Enter Address:");
		String address = scan.next();
		System.out.println("Enter Date of birth in format DD/MM/YYYY:");
		String date = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		try {
			/*Customer customer = new Customer(1009, "Charls Darwin", "6547389210", "Hyderabad", "TYRUEIWOQP", "YTURIEOWPQ");
			customerService.createCustomer(customer);*/
			Account account = new Account();
			account.setAccountHolderName(name);
			account.setAccountStatus(true);
			account.setAccountType(accountType);
			account.setAddress(address);
			account.setBalance(balance);
			account.setContactNumber(contact);
			account.setDob(localDate);
			account.setCustomerId(1009);
			System.out.println(accountService.createAccount(account));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

 

	public static void getAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter account Id:");
		String accountId = scan.next();
		Optional<Account> returnedAccount = accountService.getAccountById(accountId);
		if (returnedAccount.isPresent())
			System.out.println(returnedAccount.get());
		else
			System.out.println("Account not found..");
		//scan.close();
	}

 

//	public static void getAllAccounts() {
//		List<Account> accounts = accountService.getAllAccounts();
//		System.out.println(accounts);
//	}
//
// 
//
//	public static void deleteAccount() {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter account Id to be deleted:");
//		String id = scan.next();
//		try {
//			boolean result = accountService.deleteAccountById(id);
//			if(result)
//				System.out.println("Deleted Successfully!!!");
//			else
//				System.out.println("Couldn't Happen");
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		//scan.close();
//	}

 

}