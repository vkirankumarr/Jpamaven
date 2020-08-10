package b18.va20055512.foundation.bank.service;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer createAccountforCustomer(int id,Account account);
	
	public Customer getCustomerAccountsById(int id);
	
	public Iterable<Customer> getAllCustomerAccounts();

}
