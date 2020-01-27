package edu.ncsu.csc316.dsa.list;

/**
 * Holds functionality common for all lists.
 * @author Isabella Samuelsson
 * @param <E> type of the element
 */
public abstract class AbstractList<E> implements List<E> {
	
	/**
	 * Adds a value to the beginning of a list.
	 * @param value to add
	 */
	@Override
	public void addFirst(E value) {
		add(0, value);
	}
	
	/**
	 * Adds a value to the end of a list.
	 * @param value to add
	 */
	@Override
	public void addLast(E value) {
		add(size(), value);
	}

	/**
	 * Checks if the index is a valid index for the list.
	 * @param index to check
	 */
	protected void checkIndex(int index)
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
		}
	}
	
	/**
	 * Checks if the index is a valid index to add to a list.
	 * @param index to check
	 */
	protected void checkIndexForAdd(int index)
	{
		if(index < 0 || index > size()) 
		{
			throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
		}
	}
	
	/**
	 * Obtains the first element in a list.
	 * @return the first element in the list
	 */
	@Override
	public E first() {
		return get(0);
	}
	
	/**
	 * Determines if the list is empty.
	 * @return true/false depending on if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Obtains the last element in the list.
	 * @return the last element
	 */
	@Override
	public E last() {
		return get(size() - 1);
	}
	
	/**
	 * Removes the first element in the list.
	 * @return the first element
	 */
	@Override
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * Removes the last element in the list.
	 * @return the last element
	 */
	@Override
	public E removeLast() {
		return remove(size() - 1);
	}
}
