package edu.ncsu.csc316.dsa.queue;


/**
 * Creates a Queue.
 * @author Isabella Samuelsson
 * @param <E> element type
 */
public interface Queue<E> {

	/**
	 * Adds an element to the end of the queue.
	 * @param value to add
	 */
	public void enqueue(E value);
	/**
	 * Removes an element from the front of the queue.
	 * @return value removed
	 */
	public E dequeue();
	/**
	 * Returns the element at the front of the queue.
	 * @return value at the front
	 */
	public E front();
	/**
	 * Returns the size of the queue.
	 * @return the size of the queue
	 */
	public int size();
	/**
	 * Returns if the stack is empty.
	 * @return true/false if stack is empty.
	 */
	public boolean isEmpty();
}
