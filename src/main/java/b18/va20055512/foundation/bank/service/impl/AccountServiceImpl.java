package b18.va20055512.foundation.bank.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.TransferFund;
import b18.va20055512.foundation.bank.exception.ResourceNotFound;
import b18.va20055512.foundation.bank.repository.AccountRepository;
import b18.va20055512.foundation.bank.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account getAccountsById(int id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Iterable<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}

	@Override
	@Transactional
	public boolean transferFunds(TransferFund funds) {
		
		Account fromAccount =getAccountsById(funds.getFromAccount());
		
		if(null != fromAccount && fromAccount.getBalance() >0 ) {
			
			Account toAccount =getAccountsById(funds.getToAccount());
			if(null == toAccount) {
				throw new ResourceNotFound("To Account doesn't exist !!!");
			}
			
			if(!(fromAccount.getBalance() > funds.getTransferAmmount())) {
				throw new ResourceNotFound("Sufficient balance not available for transfer !!!");
			}else {
				int amount=funds.getTransferAmmount()+toAccount.getBalance();
				toAccount.setBalance(amount);
				
				accountRepository.save(toAccount);
				int amount1=fromAccount.getBalance()-funds.getTransferAmmount();
				fromAccount.setBalance(amount1);
				
				accountRepository.save(fromAccount);
				
			}
		}
		
		
		
		return true;
	}

}
