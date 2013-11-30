package labs;

import static org.junit.Assert.assertEquals;
import labs.Vector3D;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Vector3DTest {
	private Vector3D v1;
	private Vector3D v2;

	@Before
	public void setUp() throws Exception {
		v1 = new Vector3D(2, 4, 6);
		v2 = new Vector3D(5, 3, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testL2norm() {
		assertEquals(2*Math.sqrt(14), v1.L2norm(), 0);
	}
	
	@Test
	public void testDotProduct() {
		assertEquals(28, v1.dotProduct(v2), 0);
	}

	@Test
	public void testCrossProduct() {
		Vector3D res = v1.crossProduct(v2);
		assertEquals(-14, res.x, 0);
		assertEquals(28, res.y, 0);
		assertEquals(-14, res.z, 0);
	}
	
	@Test
	public void testNormalize() {
		v1.normalize();
		
		double magnitude = 2*Math.sqrt(14);
		
		assertEquals(2/magnitude, v1.x, 0);
		assertEquals(4/magnitude, v1.y, 0);
		assertEquals(6/magnitude, v1.z, 0);
	}
	
}
