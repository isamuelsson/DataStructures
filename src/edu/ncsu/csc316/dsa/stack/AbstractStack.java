package edu.ncsu.csc316.dsa.stack;

/**
 * Creates an AbstractStack.
 * @author Isabella Samuelsson
 * @param <E> element type
 */
public abstract class AbstractStack<E> implements Stack<E> {
	/**
	 * Checks if a stack is empty.
	 * @return true/false
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}
