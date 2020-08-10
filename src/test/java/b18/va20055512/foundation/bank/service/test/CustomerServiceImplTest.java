package b18.va20055512.foundation.bank.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.Customer;
import b18.va20055512.foundation.bank.repository.CustomerRepository;
import b18.va20055512.foundation.bank.service.impl.CustomerServiceImpl;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock
	CustomerRepository customerRepo;
	
	@Test
	public void createCustomerTest() {
		
		Customer cust=new Customer();
		
		cust.setFirstName("Shyam");
		cust.setLastName("Karla");
		cust.setEmail("shyam.karla@wipro.com");
		
		when(customerRepo.save(cust)).thenReturn(cust);
		
		Customer response=customerService.createCustomer(cust);
		assertEquals(cust.getFirstName(),response.getFirstName());
		assertNotNull(response.getCustomerId());
		
	}
	
	@Test
	public void updateCustomerTest() {
		
		Customer cust=new Customer();
		cust.setCustomerId(1);
		cust.setFirstName("");
		
		when(customerRepo.save(cust)).thenReturn(cust);
		
		Customer response=customerService.updateCustomer(cust);
		assertEquals(response.getFirstName(),"");
		
	}
	
	@Test
	public void getCustomerAccountsByIdTest() {
		
		Customer cust=new Customer();
		cust.setCustomerId(1);
		cust.setFirstName("Shyam");
		cust.setLastName("Karla");
		cust.setEmail("shyam.karla@wipro.com");
		
		
		
		Set<Account> accounts =new HashSet<>();
		
		Account account = new Account();
		account.setAccountType("Savings");
		account.setBalance(1000);
		accounts.add(account);
		cust.setAccounts(accounts);
		when(customerRepo.findById(1)).thenReturn(Optional.of(cust));
		
		customerService.getCustomerAccountsById(1);
		
		assertNotNull(cust.getAccounts());
	}
	
	@Test
	public void getAllCustomerAccountsTest() {
		Iterable<Customer> customers =  null;
		Customer cust=new Customer();
		cust.setCustomerId(1);
		cust.setFirstName("Shyam");
		cust.setLastName("Karla");
		cust.setEmail("shyam.karla@wipro.com");
		Set<Account> accounts =new HashSet<>();
		
		Account account = new Account();
		account.setAccountType("Savings");
		account.setBalance(1000);
		accounts.add(account);
		cust.setAccounts(accounts);
		when(customerRepo.findAll()).thenReturn(customers);
		
		customerService.getAllCustomerAccounts();
		
		assertNotNull(cust.getAccounts());
	}

	

}
