package boletinJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testAccount() {
		Account a = new Account("Raul",1234,1000.5f);
	} 

	@Test
	public void testDeposit() {
		
		Account a = new Account("Raul",1234,0f);
				
		assertEquals(false,a.deposit(-5f));
		assertEquals(true,a.deposit(10f));
		
	}

	@Test
	public void testWithdraw() {
		Account a = new Account("Raul",1234,1000f);
		
		assertEquals(false,a.withdraw(1500, 900));
		assertEquals(true,a.withdraw(1, 1));
		
		
	}



	@Test
	public void testToString() {
		 Account a = new Account("Raul",1234,1000f);
		 String ej = "1234	Raul	1000,00 €";
		 assertEquals(ej, a.toString());
	}

}
