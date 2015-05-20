package PaymentSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentAuthorizationTest {
	
	private PaymentAuthorization PA;
	
	@Before
	public void setup() {
		PA = new PaymentAuthorization();
	}

	@Test
	public void testMakePayment() {
		if(!(PA.makePayment("", 100))) {
			fail("Pay by cash not accepted");
		} else if (!(PA.makePayment("1234567891234567", 100))) {
			fail("Pay by card not accepted");
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCardNum() {
		PA.makePayment("1234", 100);
	}
	
	@Test
	public void testAmounts() {
		
		//Invalid amounts
		testInvalidAmount(0);
		testInvalidAmount(-1);
		testInvalidAmount(-100);
		testInvalidAmount(Integer.MIN_VALUE);
		
		//Valid amounts
		PA.makePayment("1234567891234567", 1);
		PA.makePayment("1234567891234567", 100);
		PA.makePayment("1234567891234567", Integer.MAX_VALUE);
	}
	
	private void testInvalidAmount(int amount) {
		try {
			PA.makePayment("1234567891234567", amount);
			fail("Expected exception to be thrown here");
		} catch (IllegalArgumentException exc) {

		}
	}

}
