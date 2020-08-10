package b18.va20055512.foundation.bank.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
import b18.va20055512.foundation.bank.entities.TransferFund;
import b18.va20055512.foundation.bank.repository.AccountRepository;
import b18.va20055512.foundation.bank.service.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class AccountServiceImplTest {
	
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Mock
	AccountRepository accountRepo;
	
	@Test
	public void getAccountsByIdTest() {
		
		Account acc=new Account();
		
		acc.setAccountNumber(1);
		acc.setAccountType("Savings");
		acc.setBalance(1000);
		
		when(accountRepo.findById(1)).thenReturn(Optional.of(acc));
		
		Account response=accountService.getAccountsById(1);
		assertEquals(acc.getAccountNumber(),response.getAccountNumber());
		assertNotNull(response.getBalance());
		
	}
	
	@Test
	public void getAllAccountsTest() {
		
		Customer cust=new Customer();
		cust.setCustomerId(1);
		cust.setFirstName("");
		Iterable<Account> accounts= null;
		when(accountRepo.findAll()).thenReturn(accounts);
		
		Iterable<Account> response=accountService.getAllAccounts();
		assertEquals(response,null);
		
	}
	
	//@Test
	public void transferFundsTest() {
		
		TransferFund funds=new TransferFund();
		
		funds.setFromAccount(1);
		funds.setToAccount(2);
		funds.setTransferAmmount(100);
		
		
		//Account acc=new Account();
		
		
		boolean response=accountService.transferFunds(funds);
		
		assertEquals(response, true);
	}
}
