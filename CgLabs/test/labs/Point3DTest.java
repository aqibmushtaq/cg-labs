package labs;

import static org.junit.Assert.assertEquals;
import labs.Point3D;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Point3DTest {

	private Point3D p1;
	private Point3D p2;

	@Before
	public void setUp() throws Exception {
		p1 = new Point3D(2, 4, 6);
		p2 = new Point3D(5, 3, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDistance() {
		assertEquals(Math.sqrt(35), p1.distance(p2), 0);
	}

}
