package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * @author Isabella Samuelsson
 * @param <E> the elements to sort
 */
public interface Sorter<E> {
	/**
	 * Sorts data into specified order.
	 * @param data the elements to sort
	 */
	public void sort(E[] data);
}
