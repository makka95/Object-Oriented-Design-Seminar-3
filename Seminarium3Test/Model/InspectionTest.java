package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InspectionTest {
	
	private Inspection inspection;
	
	@Before
	public void setup() {
		this.inspection = new Inspection("ABC123");
	}
	
	@Test
	public void testCreateInspectionWithIllegalArgument() {
		try {
			this.inspection = new Inspection("ABC12");
		} catch(IllegalArgumentException exc) {
			try {
				this.inspection = new Inspection("ABC123A");
			} catch (IllegalArgumentException exce) {
				
			}
		}
	}

	@Test
	public void testGetNextInspectionPoint() {
		if(this.inspection.getNextInspectionPoint() == null) {
			fail("Returned null instead of an inspection point");
		}
	}
	
	@Test
	public void testMakePayment() {
		String cardNum = "1234567891234567";
		inspection.makePayment(cardNum);
	}

}
