package edu.ncsu.csc316.dsa;

/**
 * A position object.
 * @author Isabella Samuelsson
 * @param <E> the type of element at the position
 */
public interface Position<E> {
	
	/**
	 * Obtains the element at the certain position.
	 * @return the element at the position
	 */
	E getElement();
}
