package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Tests the PositionalLinkedList class.
 * @author Isabella Samuelsson
 */
public class PositionalLinkedListTest { 
	/** test list */
	private PositionalList<String> list;
	
	/**
	 * Creates testing environment
	 */
	@Before
	public void setUp() {
		list = new PositionalLinkedList<String>();   
	}
	
	/**
	 * Tests the first method
	 */
	@Test
	public void testFirst() { 
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		try{
			list.first();
		} catch(Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
		
		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		
		//add
	}
	
	/**
	 * Tests the last method
	 */
	@Test
	public void testLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());  
		
		list.addLast("Hi");
		list.addLast("Hey");
		list.addLast("Hola");
		
		assertEquals(list.last().getElement(), "Hola"); 
	}
	
	/**
	 * Tests the addFirst method
	 */
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		
		assertEquals(first, list.first());
		
		Position<String> two = list.addFirst("two");
		
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());
		assertEquals(list.first().getElement(), "two"); 
		
		assertEquals(two, list.first());
	}
	
	/**
	 * Tests the addLast method
	 */
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		
		assertEquals(first, list.first());
		
		list.addLast("Hi");
		list.addLast("Hey");
		list.addLast("Hola");
		
		assertEquals(list.last().getElement(), "Hola"); 
	}
	
	/**
	 * Tests the before method
	 */
	@Test
	public void testBefore() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		
		list.addLast("Hi");
		list.addLast("Hey");
		Position<String> last = list.addLast("Hola");
		
		assertEquals(list.before(last).getElement(), "Hey");
	}
	
	/**
	 * Tests the after method
	 */
	@Test
	public void testAfter() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		
		list.addLast("Hi");
		Position<String> secLast = list.addLast("Hey");
		Position<String> last = list.addLast("Hola");
		
		assertEquals(list.after(secLast).getElement(), "Hola");
		assertEquals(last, list.last());
		
		try {
			list.after(last);
		}
		catch(NoSuchElementException e) {
			assertEquals(last, list.last());
		}
	}
	
	/**
	 * Tests the addBefore method
	 */
	@Test
	public void testAddBefore() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		
		list.addLast("Hi");
		Position<String> secLast = list.addLast("Hey");
		Position<String> last = list.addLast("Hola");
		
		list.addBefore(last, "bye");
		
		assertEquals(list.after(secLast).getElement(), "bye");
		assertEquals(list.before(last).getElement(), "bye");
	}
	
	/**
	 * Tests the addAfter method
	 */
	@Test
	public void testAddAfter() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size()); 
		assertEquals(first, list.first());
		
		list.addLast("Hi");
		Position<String> secLast = list.addLast("Hey");
		Position<String> last = list.addLast("Hola");
		assertEquals(secLast, list.before(last));
		
		list.addAfter(last, "bye");
		
		assertEquals(list.last().getElement(), "bye");
		assertEquals(list.after(last).getElement(), "bye");
	}
	
	/**
	 * Tests the set method
	 */
	@Test
	public void testSet() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		
		list.addLast("Hi");
		Position<String> secLast = list.addLast("Hey");
		Position<String> last = list.addLast("Hola");
		
		list.set(last, "bye");
		
		assertEquals(list.last().getElement(), "bye");
		assertEquals(list.after(secLast).getElement(), "bye");
		
	}
	
	/**
	 * Tests the remove method
	 */
	@Test
	public void testRemove() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		
		Position<String> sec = list.addLast("Hi");
		Position<String> secLast = list.addLast("Hey");
		Position<String> last = list.addLast("Hola");
		
		assertEquals(secLast, list.before(last));
		
		list.remove(last);
		
		assertEquals(list.last().getElement(), "Hey");
		
		list.remove(sec);
		
		assertEquals(list.after(first).getElement(), "Hey");
	}
	
	/**
	 * Tests the iterator method
	 */
	@Test
	public void testIterator() {   //element and positional it need more
		/// Start with an empty list
		
		
		
		
		assertEquals(0, list.size());
		Position<String> first = list.addFirst("one");
		Position<String> second = list.addLast("two");
		Position<String> third = list.addLast("three");
		assertEquals(3, list.size());
		
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals(first.getElement(), it.next());
		assertEquals(second.getElement(), it.next());
		assertEquals(third.getElement(), it.next()); 
		
		it.remove();
		assertEquals(2, list.size());
		
		
	
	}
	
	/**
	 * Tests the positions method
	 */
	@Test
	public void testPositions() {
		assertEquals(0, list.size());
		
		Iterator<Position<String>> it = list.positions().iterator();
		
		try {
			it.next();
		}
		catch(NoSuchElementException e){
			assertEquals(it.hasNext(), false);
		}
		
		Position<String> first = list.addFirst("one");
		Position<String> second = list.addLast("two");
		Position<String> third = list.addLast("three");
		assertEquals(3, list.size());
		
		it = list.positions().iterator();
		assertTrue(it.hasNext());
		assertEquals(first, it.next());
		assertEquals(second, it.next());
		assertEquals(third, it.next());
		
		//add
	}

}
