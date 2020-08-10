package b18.va20055512.foundation.bank.service;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.TransferFund;

public interface AccountService {
	
	public Account getAccountsById(int id);
	
	public Iterable<Account> getAllAccounts();
	
	public boolean transferFunds(TransferFund funds);

}
