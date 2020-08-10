package b18.va20055512.foundation.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.Customer;
import b18.va20055512.foundation.bank.exception.ResourceNotFound;
import b18.va20055512.foundation.bank.service.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;


	@PostMapping("/{Id}/accounts")
	public ResponseEntity<Customer> createAccountforCustomer(@PathVariable String Id, @RequestBody Account account)  throws ResourceNotFound{
		Customer customers = customerService.createAccountforCustomer(Integer.parseInt(Id),account);
		

		return new ResponseEntity<Customer>(customers, HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer cust=customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String Id,@RequestBody Customer customer){
		customer.setCustomerId(Integer.parseInt(Id));
		Customer cust=customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		
	}
	@GetMapping("/{Id}/accounts")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String Id){
		
		return new ResponseEntity<Customer>(customerService.getCustomerAccountsById(Integer.parseInt(Id)),
				HttpStatus.OK);
		
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<Iterable<Customer>> getCustomers(){
		
		return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomerAccounts(),
				HttpStatus.OK);
		
	}
	
	@GetMapping("/health")
	public String health(){
		
		return "Application is running";
		
	}
	
	
}
