package edu.ncsu.csc316.dsa.list.positional;

import edu.ncsu.csc316.dsa.Position;

/**
 * Creates a Positional List with add before, after, first and last functionality.
 * @author Isabella Samuelsson
 * @param <E> element type
 */
public interface PositionalList<E> extends Iterable<E> {
	
	/**
	 * Adds an element after a specified position
	 * @param p the position to add after
	 * @param value to add
	 * @return the new position created
	 */
	public Position<E> addAfter(Position<E> p, E value);
	/**
	 * Adds an element before a specified position
	 * @param p the position to add after
	 * @param value to add
	 * @return the new position created
	 */
	public Position<E> addBefore(Position<E> p, E value);
	/**
	 * Adds an element at the beginning of the list
	 * @param value to add
	 * @return the new position created
	 */
	public Position<E> addFirst(E value);
	/**
	 * Adds an element at the end of the list
	 * @param value to add
	 * @return the new position created
	 */
	public Position<E> addLast(E value);
	/**
	 * Returns the position after a specified position
	 * @param p the initial position
	 * @return the position after
	 */
	public Position<E> after(Position<E> p);
	/**
	 * Returns the position before a specified position
	 * @param p the initial position
	 * @return the position before
	 */
	public Position<E> before(Position<E> p);
	/**
	 * Returns the first position in a list
	 * @return the first position
	 */
	public Position<E> first();
	/**
	 * Determines if the list is empty
	 * @return true/false
	 */
	public boolean isEmpty();
	/**
	 * Returns the last position in a list
	 * @return the last position
	 */
	public Position<E> last();
	/**
	 * Returns an Iterable object
	 * @return an Iterable object
	 */
	public Iterable<Position<E>> positions();
	/**
	 * Removes the specified position from the list.
	 * @param p the position to remove
	 * @return the removed element at the position
	 */
	public E remove(Position<E> p);
	/**
	 * Sets a new value at a specified position.
	 * @param p the position to set
	 * @param value the new value
	 * @return the previous value
	 */
	public E set(Position<E> p, E value);
	/**
	 * Obtains the size of the list.
	 * @return the size
	 */
	public int size();
}