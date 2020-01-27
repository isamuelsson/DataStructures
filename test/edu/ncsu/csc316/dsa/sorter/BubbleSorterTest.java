package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;
/**
 * Tests the BubbleSorter class.
 * @author Isabella Samuelsson
 */
public class BubbleSorterTest {

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
	private BubbleSorter<Student> sorter;

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
		
	}
	
	/**
	 * Tests the sort method on Student objects using a ID comparator.
	 */
	@Test
	public void testSortStudentID() {
		StudentIDComparator idComp = new StudentIDComparator();
		sorter = new BubbleSorter<Student>(idComp);
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		

		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);
	}
	/**
	 * Tests the sort method on Student objects using a GPA comparator.
	 */
	@Test
	public void testSortStudentGPA() {
		StudentGPAComparator gpaComp = new StudentGPAComparator();
		sorter = new BubbleSorter<Student>(gpaComp);
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(original[i]);
		}
		

		assertEquals(sOne, original[4]);
		assertEquals(sTwo, original[3]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[1]);
		assertEquals(sFive, original[0]);
	}


}
