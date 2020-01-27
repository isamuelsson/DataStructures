package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Creates an array based list with an iterator. Has add and remove functionality.
 * @author Isabella Samuelsson
 * @param <E> the type of element
 */
public class ArrayBasedList<E> extends AbstractList<E> {
	/** initial capacity */
	private final static int DEFAULT_CAPACITY = 10;
	/** array to hold list elements */
	private E[] data;
	/** size of list */
	private int size;

	/**
	 * Creates an array based list with default capacity.
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an array based list with a specified capacity.
	 * @param capacity of the list
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}
	
	/**
	 * Determines if the array should grow to make space for more elements.
	 * @param minCapacity size of the array
	 */
	private void ensureCapacity(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 2) + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

	/**
	 * Adds an element to a specific index in the list.
	 * @param index to add at
	 * @param value to add
	 */
	@Override
	public void add(int index, E value) {
		ensureCapacity(index);
		checkIndexForAdd(index);
		
		if(index == size) {
			data[size] = value;
			size ++;
		}
		else {
			for(int i = size; i > index; i--) {
				data[i] = data[i - 1];
			}
			data[index] = value;
			size++;
		}		
	}

	/**
	 * Obtains element at a specified index.
	 * @param index of the element
	 * @return the element
	 */
	@Override
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}

	/**
	 * Removes element at a specified index.
	 * @param index of the element
	 * @return the element removed
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);
		E value = data[index];
		for(int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size] = null;
		size--;
		return value;
	}

	/**
	 * Sets an elements new value.
	 * @param index of the element
	 * @param value to set
	 * @return the previous value
	 */
	@Override
	public E set(int index, E value) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E save = data[index];
		data[index] = value;
		return save;
	}

	/**
	 * Obtains the size of the list.
	 * @return the size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Obtains an iterator object.
	 * @return the iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	/**
	 * Iterator object to traverse and alter the Array based list.
	 * @author Isabella Samuelsson
	 */
	public class ElementIterator implements Iterator<E> {
		/** current index */
		private int position;
		/** if have element to remove */
		private boolean removeOK;
		
		/**
		 * Creates an iterator object.
		 */
		public ElementIterator() {
			position = 0;
			removeOK = false;
		}
		
		
		/**
		 * Determines if their is another element in the array.
		 * @return true/false 
		 */
		public boolean hasNext() {
			if(position < size) {
				return true;
			}
			return false;
		}
		
        /**
         * Obtains the next element in the array.
         * @return the next element
         */
        public E next() {
        	if(this.hasNext()) {
        		position++;
        		removeOK = true;
        		return data[position - 1];
        	}
			return null;
		}
        
        /**
         * Removes the element in the array that the iterator has 
         * just passed over.
         */
        public void remove() {
			if(removeOK) {
				ArrayBasedList.this.remove(position - 1);
				position --;
			}
			removeOK = false;
		}
	}
	
}
