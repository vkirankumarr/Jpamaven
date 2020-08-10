package b18.va20055512.foundation.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b18.va20055512.foundation.bank.entities.Account;
import b18.va20055512.foundation.bank.entities.TransferFund;
import b18.va20055512.foundation.bank.service.AccountService;

@RestController
@RequestMapping("accounts/")
public class AccountController {
	@Autowired
	AccountService accountService;
	@GetMapping("/{Id}")
	public ResponseEntity<Account> getAccountById(@PathVariable String Id){
		
		return new ResponseEntity<Account>(accountService.getAccountsById(Integer.parseInt(Id)),HttpStatus.OK);
		
	}
	@GetMapping
	public ResponseEntity<Iterable<Account>> getAccounts(){
		
		return new ResponseEntity<Iterable<Account>>(accountService.getAllAccounts(),HttpStatus.OK);
		
	}
	@PutMapping("/transferFund")
	public ResponseEntity<String> transferFund(@RequestBody TransferFund funds){
		boolean response =accountService.transferFunds(funds);
		String msg="Amount transferred failed !!!";
		HttpStatus status= HttpStatus.INTERNAL_SERVER_ERROR;
		if(response) {
			msg="Amount transferred successfully";
			status=HttpStatus.OK;
		}
		return new ResponseEntity<String>(msg,status);
		
	}
	
}
