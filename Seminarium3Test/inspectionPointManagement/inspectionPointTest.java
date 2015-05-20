package inspectionPointManagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class inspectionPointTest {
	
	private String DESCRIPTION = "A valid description";
	private String REGNUMBER = "abc123";
	private int NUM = 12;
	private inspectionPoint point;

	@Test
	public void testValidParameters() {
		this.point = new inspectionPoint(NUM, REGNUMBER, DESCRIPTION);
	}
	
	@Test(expected = NullPointerException.class)
	public void testInvalidRegNumber() {
		this.point = new inspectionPoint(NUM, null, DESCRIPTION);
		fail("There should have been an error when entering a null value for regNumber");
	}
	
	@Test(expected = NullPointerException.class)
	public void testInvalidDescr() {
		this.point = new inspectionPoint(NUM, REGNUMBER, null);
		fail("There should have been an error when entering a null value for descr");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testToShortRegNumber() {
		this.point = new inspectionPoint(NUM, "abc", DESCRIPTION);
		fail("There should have been an error when entering an invalid length for regNumber");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testToLongRegNumber() {
		this.point = new inspectionPoint(NUM, "abc123abc", DESCRIPTION);
		fail("There should have been an error when entering an invalid length for regNumber");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidNum() {
		this.point = new inspectionPoint(-10000, REGNUMBER, DESCRIPTION);
		fail("There should have been an error when entering an negative number for num");
	}

}
