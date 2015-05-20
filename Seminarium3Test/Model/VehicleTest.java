package Model;

import static org.junit.Assert.*;
import inspectionPointManagement.inspectionPoint;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

	private Vehicle vehicle;
	
	@Before
	public void setup(){
		this.vehicle = new Vehicle("ABC123");
	}
	
	@Test
	public void testGetInspectionPoints() {
		if (vehicle.getNextInspectionPoint() == null) {
			fail("There should have been an inspectionPoint returned");
		}
	}
	
	@Test
	public void testResetListGenerator () {
		inspectionPoint point = vehicle.getNextInspectionPoint();
		vehicle.resetListIterator();
		assertEquals(point, vehicle.getNextInspectionPoint());
	}
	

}
