package scratch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;

public class AssertTest {
	
	class InsufficientFundsException extends RuntimeException {
		public InsufficientFundsException(String message) {
			super(message);
		}
		private static final long serialVersionUID = 1L;
		
	}
	
	class Account {
		int balance;
		String name;
		
		Account(String name) {
			this.name = name;
		}
		
		void deposit(int dollars) {
			balance += dollars;
		}
		
		void withdraw(int availableBalance) {
			if (balance < availableBalance) {
				throw new InsufficientFundsException("Available balance " + balance);
			}
			balance -= availableBalance;
		}
		
		public String getName() {
			return name;
		}
		
		public int getBalance() {
			return balance;
		}
		
		public boolean hasPositiveBalance() {
			return balance > 0;
		}
	}
	
	class Customer {
		List<Account> accounts = new ArrayList<>();
		
		void add(Account account) {
			accounts.add(account);
		}
		
		Iterator<Account> getAccounts(){
			return accounts.iterator();
		}
	}

	private Account account;
	
	@Before
	public void createAccount() {
			account = new Account("an account name");
	}
	
	@Test
	public void hasPositiveBalance() {
		account.deposit(50);
		Assert.assertTrue(account.hasPositiveBalance());
	}
	
	@Test
	public void depositIncreasesBalance() {
		int initialBalance = account.getBalance();
		account.deposit(100);
		Assert.assertTrue(account.getBalance() > initialBalance);
		Assert.assertThat(account.getBalance() > 0, is(equalTo(true)));
	}
		
	@Test
	public void variousMatchTesters() {
		Account account = new Account("my cash rich account");
		Assert.assertThat(account.getName(), is(equalTo("my cash rich account")));
		
		Assert.assertThat(account.getName(), allOf(startsWith("my"), endsWith("account")));
		
		Assert.assertThat(account.getName(), anyOf(startsWith("my"), endsWith("loot")));
		
		Assert.assertThat(account.getName(), not(equalTo("credit")));
		
		Assert.assertThat(account.getName(), is(not(nullValue())));
		Assert.assertThat(account.getName(), is(notNullValue()));
		
		Assert.assertThat(account.getName(), isA(String.class));
	
	}
	
	@Test (expected=InsufficientFundsException.class)
	public void throwsWhenWithdrawingTooMuch() {
		account.withdraw(1000000);
	}
	
	@Test
	public void throwsWhenWithdrawingTooMuchTryCatch() {
		try {
			account.withdraw(100);
		}
		catch(InsufficientFundsException expected){
			Assert.assertThat(expected.getMessage(), equalTo("Available balance 0"));
		}
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void exceptionRule() {
		thrown.expect(InsufficientFundsException.class);
		thrown.expectMessage("Available balance 0");
		
		account.withdraw(100);
	}
	
	@Test
	public void readsFromTestFile() throws IOException {
		String filename = "test.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write("test data");
		writer.close();
	}
	
}


