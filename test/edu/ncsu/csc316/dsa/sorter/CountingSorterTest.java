package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests the CountingSorter class.
 * @author Isabella Samuelsson
 */
public class CountingSorterTest {
	
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
	
	/* Test sorter */
	private CountingSorter<Student> sorter;
	
	/**
	 * Setup method for testing environment.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		sorter = new CountingSorter<Student>();
	}
	/**
	 * Tests the sort method on Student objects, sorts by comparing GPA.
	 */
	@Test
	public void testSortStudentGPA() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		
		sorter.sort(original);
		
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
		
		Student[] original2 = { sFour, sThree, sTwo, sOne, sFive };
		
		sorter.sort(original2);
		
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
		
		Student[] original3 = { sOne, sTwo, sThree, sFour, sFive };
		
		sorter.sort(original3);
		
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}
	
	

}
