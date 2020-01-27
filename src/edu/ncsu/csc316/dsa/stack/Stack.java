package edu.ncsu.csc316.dsa.stack;

/**
 * Creates a Stack.
 * @author Isabella Samuelsson
 * @param <E> the element type
 */
public interface Stack<E> {
	/**
	 * Adds a value to the top of the stack.
	 * @param value to add to the stack
	 */
	public void push(E value);
	/**
	 * Removes a value from the top of the stack.
	 * @return value from the stack
	 */
	public E pop();
	/**
	 * Returns the value on the top of the stack.
	 * @return value from the stack
	 */
	public E top();
	/**
	 * Obtains the size of the stack.
	 * @return size
	 */
	public int size();
	/**
	 * Determines if the stack is empty.
	 * @return true/false if stack is empty
	 */
	public boolean isEmpty();

}
