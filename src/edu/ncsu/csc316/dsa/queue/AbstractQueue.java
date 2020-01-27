package edu.ncsu.csc316.dsa.queue;

/**
 * Creates an AbstractQueue.
 * @author Isabella Samuelsson
 * @param <E> element type
 */
public abstract class AbstractQueue<E> implements Queue<E> {

	/**
	 * Checks if the queue is empty.
	 * @return true/false if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}
