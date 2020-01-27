package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * Creates a Stack with a LinkedList storage type.
 * @author Isabella Samuelsson
 * @param <E> element type
 */
public class LinkedStack<E> extends AbstractStack<E> {
	/** element storage */
	private SinglyLinkedList<E> list;
	
	/**
	 * Constructs a LinkedStack.
	 */
	public LinkedStack()
	{
		list = new SinglyLinkedList<E>();
	}

	/**
	 * Adds an element to the top of the stack.
	 * @param value added
	 */
	@Override
	public void push(E value) {
		list.addFirst(value);
		
	}

	/**
	 * Removes an element from the top of the stack.
	 * @return value removed
	 */
	@Override
	public E pop() {
		E save;
		try {
			save = list.removeFirst();
		}
		catch(Exception e) {
			throw new EmptyStackException();
		}
		return save;
	}
	
	/**
	 * Returns the element at the top of the stack.
	 * @return top value on stack
	 */
	@Override
	public E top() {
		E save;
		try {
			save = list.first();
		}
		catch(Exception e) {
			throw new EmptyStackException();
		}
		return save;
	}

	/**
	 * Returns the size of the stack.
	 * @return size of the stack
	 */
	@Override
	public int size() {
		return list.size();
	}
	
}
