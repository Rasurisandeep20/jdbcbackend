package com.dnb.jdbcdemo2.service;
import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo2.dto.Customer;
import com.dnb.jdbcdemo2.exception.IdNotFoundException;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	
	public Optional<Customer> getCustomerById(Integer CustomerId);
	
	public String deleteAccount(String CustomerId);
	
	public Iterable<Customer> getAllCustomers();

	public boolean deleteAccountByID(Integer id) throws IdNotFoundException;
	
}