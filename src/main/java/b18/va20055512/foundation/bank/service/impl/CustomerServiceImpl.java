package b18.va20055512.foundation.bank.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.Customer;
import b18.va20055512.foundation.bank.exception.ResourceNotFound;
import b18.va20055512.foundation.bank.repository.CustomerRepository;
import b18.va20055512.foundation.bank.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	
	public Customer getCustomerById(int id) {
		Optional<Customer> cust =customerRepository.findById(id);
		
		return cust.get();
	}

	@Override
	public Customer createAccountforCustomer(int id, Account account) {
		Optional<Customer> existingCustomer =customerRepository.findById(id);
		if(!existingCustomer.isPresent()) {
			
				throw new ResourceNotFound("Customer doesn't exist!!!");
			
		}
		Set<Account> accounts=new HashSet<>();
		accounts.add(account);
		 Customer customer =existingCustomer.get();
		 customer.setAccounts(accounts);
		 
		 Set<Customer> customers =new HashSet<>();
		 customers.add(customer);
		 
		 account.setCustomers(customers);
		Customer updatedCustomer= customerRepository.save(customer);
		return updatedCustomer;
	}

	@Override
	public Customer getCustomerAccountsById(int id) {
		
		return customerRepository.findById(id).get();
	}

	@Override
	public Iterable<Customer> getAllCustomerAccounts() {
		return customerRepository.findAll();
	}

}
