package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests the Student class.
 * @author Isabella Samuelsson
 */
public class StudentTest {
	/* Test student 1 */
	private Student sOne;
	/* Test student 2 */
	private Student sTwo;
	/* Test student 3 */
	private Student sThree;
	/* Test student 4 */
	private Student sFour;
	/* Test student 5 */
	private Student sFive;
	
	/**
	 * Creates the testing environment.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
	}
	
	/**
	 * Tests the set first name method.
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Tests the set last name method.
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Tests the set id method.
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Tests the set gpa method.
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}
	
	/**
	 * Tests the set unityId method.
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}
	
	/**
	 * Tests the set credit hour method.
	 */
	@Test
	public void testSetCreditHours() {
		sOne.setCreditHours(11);
		assertEquals(11, sOne.getCreditHours());
	}

	/**
	 * Tests the compareTo method.
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);
	}
	
	/**
	 * Tests the set toString method.
	 */
	@Test
	public void testToString() {
		assertEquals(sOne.toString(), "Student first=OneFirst, last=OneLast, id=1, creditHours=1, gpa=1.0, unityID=oneUnityID");
		
	}
	
	/**
	 * Tests the equals method.
	 */
	@Test
	public void testEquals() {
		assertFalse(sOne.equals(sTwo));
		assertFalse(sOne.equals(sThree));
		assertFalse(sOne.equals(sFour));
		assertFalse(sOne.equals(sFive));
		assertTrue(sOne.equals(sOne));
	}
	
	/**
	 * Tests the hashcode method.
	 */
	@Test
	public void testHascode() {
		assertFalse(sOne.hashCode() == sTwo.hashCode());
		assertFalse(sTwo.hashCode() == sThree.hashCode());
		assertFalse(sFour.hashCode() == sFive.hashCode());
		assertFalse(sFive.hashCode() == sTwo.hashCode());
	}
	
	
}
