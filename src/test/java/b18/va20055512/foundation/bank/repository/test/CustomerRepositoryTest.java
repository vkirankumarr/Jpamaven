package b18.va20055512.foundation.bank.repository.test;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.Customer;
import b18.va20055512.foundation.bank.repository.CustomerRepository;
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CustomerRepositoryTest {



	
	@Autowired
	CustomerRepository customertRepository;
	
	@Test
	void saveCusomers() {
		
		Customer cust1 =new Customer();
		Customer cust2 =new Customer();
		
		cust1.setFirstName("Aryan");
		cust1.setLastName("Karla");
		cust1.setEmail("charn.teja@wipro.com");
		
		cust2.setFirstName("Anisha");
		cust2.setLastName("Karla");
		cust2.setEmail("kiran.kumar@wipro.com");
		
		Account savingsAcc=new Account();
		Account currentAcc=new Account();
		
		savingsAcc.setAccountType("SAVINGS");
		savingsAcc.setBalance(10000);
		
		currentAcc.setAccountType("CURRENT");
		currentAcc.setBalance(20000);
		
		Set<Account> accounts=new HashSet<>();
		
		accounts.add(savingsAcc);
		accounts.add(currentAcc);
		
		cust1.setAccounts(accounts);
		cust2.setAccounts(accounts);
		
		Set<Customer> customers=new HashSet<>();
		customers.add(cust1);
		customers.add(cust2);
		
		
		
		savingsAcc.setCustomers(customers);
		currentAcc.setCustomers(customers);
		
		customertRepository.save(cust1);
		customertRepository.save(cust2);
		
	}
	@Test
	@Transactional
	void getAllCustomers() {
		
		Iterable<Customer> customers = customertRepository.findAll();
		
		for (Customer customer : customers) {
			System.out.println("customer :"+customer.toString());
			Set<Account> accounts= customer.getAccounts();
			for (Account account : accounts) {
				System.out.println("acconut :"+account.toString());
			}
		}
	}
	
	





}
