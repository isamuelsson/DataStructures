package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
/**
 * Tests the InsertionSorter class.
 * @author Isabella Samuelsson
 */
public class InsertionSorterTest {

	/* Test array with integer data in ascending order */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	/* Test array with data in descending order */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	/* Test array with data in random order */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	
	/* Test student 1 */
	private Student st1 = new Student("Isa", "Sam", 23, 13, 4.13, "insa");
	/* Test student 2 */
	private Student st2 = new Student("Cam", "Cob", 24, 13, 4.13, "camco");
	/* Test student 3 */
	private Student st3 = new Student("Em", "Sho", 25, 13, 3.7, "emsh");
	/* Test student 4 */
	private Student st4 = new Student("Am", "Ric", 26, 13, 3.6, "amric");
	/* Test student 5 */
	private Student st5 = new Student("Isa", "Ric", 27, 13, 3.6, "imric");
	/* Test student 6 */
	private Student st6 = new Student("Isa", "Ric", 28, 13, 3.6, "jmric");
	
	/* Test array with student data in ascending order */
	private Student[] dataAscending2 = { st2, st4, st5, st6, st1, st3 };
	/* Test array with student data in descending order */
	private Student[] dataDescending2 = { st3, st1, st6, st5, st4, st2 };
	/* Test array with student data in random order */
	private Student[] dataRandom2 = { st1, st2, st3, st4, st6, st5 };

	/* Test sorter */
	private InsertionSorter integerSorter;
	
	/**
	 * Setup method for testing environment.
	 */
	@Before
	public void setUp() {
		integerSorter = new InsertionSorter();
	}
	
	/**
	 * Tests the InsertionSorter sort method on Integerobjects.
	 */
	@Test
	public void testSortIntegers() {
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		Integer five = 5;
		
		integerSorter.sort(dataAscending);
		assertEquals(one.compareTo(dataAscending[0]), 0);
		assertEquals(two.compareTo(dataAscending[1]), 0);
		assertEquals(three.compareTo(dataAscending[2]), 0);
		assertEquals(four.compareTo(dataAscending[3]), 0);
		assertEquals(five.compareTo(dataAscending[4]), 0);

		integerSorter.sort(dataDescending);
		assertEquals(one.compareTo(dataDescending[0]), 0);
		assertEquals(two.compareTo(dataDescending[1]), 0);
		assertEquals(three.compareTo(dataDescending[2]), 0);
		assertEquals(four.compareTo(dataDescending[3]), 0);
		assertEquals(five.compareTo(dataDescending[4]), 0);

		integerSorter.sort(dataRandom);
		assertEquals(one.compareTo(dataRandom[0]), 0);
		assertEquals(two.compareTo(dataRandom[1]), 0);
		assertEquals(three.compareTo(dataRandom[2]), 0);
		assertEquals(four.compareTo(dataRandom[3]), 0);
		assertEquals(five.compareTo(dataRandom[4]), 0);
	}

	/**
	 * Tests the InsertionSorter sort method on Student objects.
	 */
	@Test
	public void testSortStudent() {
		
		integerSorter.sort(dataRandom2);		
		assertTrue(st2.equals(dataRandom2[0]));
		assertTrue(st4.equals(dataRandom2[1]));
		assertTrue(st5.equals(dataRandom2[2]));
		assertTrue(st6.equals(dataRandom2[3]));
		assertTrue(st1.equals(dataRandom2[4]));
		assertTrue(st3.equals(dataRandom2[5]));
		
		integerSorter.sort(dataDescending2);		
		assertTrue(st2.equals(dataDescending2[0]));
		assertTrue(st4.equals(dataDescending2[1]));
		assertTrue(st5.equals(dataDescending2[2]));
		assertTrue(st6.equals(dataDescending2[3]));
		assertTrue(st1.equals(dataDescending2[4]));
		assertTrue(st3.equals(dataDescending2[5]));
		
		integerSorter.sort(dataAscending2);		
		assertTrue(st2.equals(dataAscending2[0]));
		assertTrue(st4.equals(dataAscending2[1]));
		assertTrue(st5.equals(dataAscending2[2]));
		assertTrue(st6.equals(dataAscending2[3]));
		assertTrue(st1.equals(dataAscending2[4]));
		assertTrue(st3.equals(dataAscending2[5]));
		
	}
}
