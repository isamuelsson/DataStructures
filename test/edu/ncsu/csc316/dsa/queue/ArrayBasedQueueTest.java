package edu.ncsu.csc316.dsa.queue;


import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ArrayBasedQueueTest {

    private Queue<String> queue;
    
    @Before
    public void setUp() {
        queue = new ArrayBasedQueue<String>();
    }
    
    @Test
    public void testEnqueue() {
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        
        queue.enqueue("one");
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
        
        //TODO: complete this test case
    }
    
    
    @Test
    public void testDequeue() {
        assertEquals(0, queue.size());
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        queue.enqueue("six");
        assertEquals(6, queue.size());
        
        assertEquals("one",  queue.dequeue());
        assertEquals(5, queue.size());
        
        //TODO: complete this test case
        
        try {
            queue.dequeue();
        } catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
    }
    
    
    @Test
    public void testFront() {
        //TODO: complete this test case
    }

}
