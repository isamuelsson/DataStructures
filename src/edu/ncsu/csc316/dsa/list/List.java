package edu.ncsu.csc316.dsa.list;

/**
 * Generic List interface.
 * @author Isabella Samuelsson
 * @param <E> the type of the elements in the list
 */
public interface List<E> extends Iterable<E> {
	
	/**
	 * Adds a value at a specified index to the list.
	 * @param index the index to add at
	 * @param value the value to add
	 */
	public void add(int index, E value);
	/**
	 * Adds a value at the first index.
	 * @param value the value to add
	 */
	public void addFirst(E value);
	/**
	 * Adds a value at the last index.
	 * @param value the value to add
	 */
	public void addLast(E value);
	/**
	 * Returns the first value in the list.
	 * @return first value
	 */
	public E first();
	
	/**
	 * Returns the element at the specified index in the list.
	 * @param index the index of the element
	 * @return the element
	 */
	public E get(int index);
	
	/**
	 * Determines if the list is empty.
	 * @return true/false depending on if the list is empty
	 */
	public boolean isEmpty();
	/**
	 * Returns the last value in the list.
	 * @return last value
	 */
	public E last();
	
	/**
	 * Removes the element at a specified index in the list.
	 * @param index of the element to be removed
	 * @return the removed element
	 */
	public E remove(int index);
	/**
	 * Removes the first element in the list.
	 * @return the removed element
	 */
	public E removeFirst();
	/**
	 * Removes the last element in the list.
	 * @return the removed element
	 */
	public E removeLast();
	/**
	 * Sets a new element to a specified index.
	 * @param index of the element
	 * @param value the new element
	 * @return the previous element
	 */
	public E set(int index, E value);
	/**
	 * Determines the size of the list.
	 * @return the size of the list
	 */
	public int size();
	
	
}
