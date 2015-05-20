package inspectionPointManagement;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class inspectionPointManagerTest {
	
	inspectionPointManager inspectionPointManager;
	
	@Before
	public void setup() {
		inspectionPointManager = new inspectionPointManager("ABC123");
	}

	@Test
	public void testInspectionPointList() {
		List<inspectionPoint> list = null;
		assertThat(inspectionPointManager.getAvailableInspectionPoints(), not(list));
	}
	
	@Test
	public void testUpdateDatabase() {
		if(!(inspectionPointManager.updateDatabase(inspectionPointManager.getAvailableInspectionPoints()))) {
			fail("There was an error testing the database");
		}
	}
	@Test(expected = NullPointerException.class)
	public void testUpdateDatabaseEmptyList() {
		List<inspectionPoint> list = null;
		if(inspectionPointManager.updateDatabase(list)) {
			fail("Expected exception to be thrown");
		}
	}

}
