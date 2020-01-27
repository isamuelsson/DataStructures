package edu.ncsu.csc316.dsa.list;



import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;



/**
 * Tests the SinglyLinkedLIst class.
 * @author Isabella Samuelsson
 */
public class SinglyLinkedListTest {
	/** test list */
	private List<String> list;

	/**
	 * Creates testing environment
	 */
	@Before
	public void setUp() {
		list = new SinglyLinkedList<String>();
	}

	/**
	 * Tests the addIndex method
	 */
	@Test
	public void testAddIndex() {
		assertEquals(0, list.size()); 
		assertTrue(list.isEmpty());

		list.add(0, "one"); 
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		
		// Use the statements above to help guide your test cases
		// for data structures: Start with an empty data structure, then
		// add an element and check the accessor method return values.
		// Then add another element and check again. Continue to keep checking
		// for special cases. For example, for an array-based list, you might
		// continue adding until you trigger a resize operation to make sure
		// the resize operation worked as expected.
		
		try{
			list.add(15,  "fifteen");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
		
	}

	/**
	 * Tests the addLast method
	 */
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());  
		
		list.addLast("Hi");
		list.addLast("Hey");
		list.addLast("Hola");

		
		assertEquals(list.get(0), "Hi");
		assertEquals(list.get(1), "Hey");
		assertEquals(list.get(2), "Hola");
		assertEquals(list.size(), 3);
	}

	/**
	 * Tests the last method
	 */
	@Test
	public void testLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());  
		
		list.add(0, "Hi");
		list.add(1, "Hey");
		list.add(2, "Hola");
		
		assertEquals(list.last(), "Hola");
	}

	/**
	 * Tests the addFirst method
	 */
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());  
		
		list.addFirst("Hi");
		list.add(1, "Hola");
		list.add(1, "Hey");
		
		
		
		assertEquals(list.get(0), "Hi");
		assertEquals(list.get(1), "Hey");
		assertEquals(list.get(2), "Hola");
		assertEquals(list.size(), 3);
	}

	/**
	 * Tests the first method
	 */
	@Test
	public void testFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());  
		
		list.add(0, "Hi");
		list.add(1, "Hey");
		list.add(2, "Hola");
		
		
		
		assertEquals(list.first(), "Hi");
	}

	/**
	 * Tests the iterator method
	 */
	@Test
	public void testIterator() {             ///if you add need to regen iterator
		// Start with an empty list
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();
		
		// Try different operations to make sure they work
		// as expected for an empty list (at this point)
		try{
			it.remove();
		} catch(Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		assertFalse(it.hasNext());

		// Now add an element
		list.addLast("one");
		
		
		
		// Use accessor methods to check that the list is correct
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", list.get(0));
		
		// Create an iterator for the list that has 1 element
		it = list.iterator();
		

		
		// Try different iterator operations to make sure they work
		// as expected for a list that contains 1 element (at this point)
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertFalse(it.hasNext());
		try{
			it.next();
		} catch(Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
		
		list.add(1, "two");
		
		it = list.iterator(); 
		
		it.next();
		
		it.remove();
		
		assertEquals(list.size(), 1);
		
	}

	/**
	 * Tests the removeIndex method
	 */
	@Test
	public void testRemoveIndex() {
		list.add(0, "Hi");
		list.add(1, "Hey");
		list.add(2, "Hello");
		list.add(3, "Hola");

		list.remove(2);
		
		assertEquals(list.get(0), "Hi");
		assertEquals(list.get(1), "Hey");
		assertEquals(list.get(2), "Hola");
		assertEquals(list.size(), 3);
		
	}

	/**
	 * Tests the removeFirst method
	 */
	@Test
	public void testRemoveFirst() {
		list.add(0, "Hi");
		list.add(1, "Hey");
		list.add(2, "Hello");
		list.add(3, "Hola");
		
		
		
		list.removeFirst();
	
		
		assertEquals(list.get(0), "Hey");
		assertEquals(list.get(1), "Hello");
		assertEquals(list.size(), 3);
	}

	/**
	 * Tests the removeLast method
	 */
	@Test
	public void testRemoveLast() {
		list.add(0, "Hi");
		list.add(1, "Hey");
		list.add(2, "Hello");
		list.add(3, "Hola");
		
		list.removeLast();
		
		assertEquals(list.get(2), "Hello");
		assertEquals(list.size(), 3);
	}

	/**
	 * Tests the set method
	 */
	@Test
	public void testSet() {
		list.add(0, "Hi");
		list.add(1, "Hey");
		list.set(0, "Hello");
		list.set(1, "Hola");
		
		assertEquals(list.get(0), "Hello");
		assertEquals(list.get(1), "Hola");
		assertEquals(list.size(), 2);
		
	}
	
	
}
