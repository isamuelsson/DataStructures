package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates a Singly Linked List with add, remove, get and set functionality.
 * @author Isabella Samuelsson
 * @param <E> type of element
 */
public class SinglyLinkedList<E> extends AbstractList<E> {
	
	/** first node in the list */
	private LinkedListNode<E> front;
	/** last node in the list */
	private LinkedListNode<E> tail;
	/** size of the list */
	private int size;
	
	/**
	 * Constructor for SinglyLinkedList.
	 */
	public SinglyLinkedList() {
		front = new LinkedListNode<E>(null);
		tail = null; 
		size = 0;
	}

	/**
	 * Adds a specified value to the list at a certain index.
	 * @param index to add at
	 * @param value to add
	 */
	@Override
	public void add(int index, E value) {
		checkIndexForAdd(index);
		
		if(index == 0) {
			if(size == 0) {
				LinkedListNode<E> insert = new LinkedListNode<E>(value);
				front.setNext(insert);
				tail = insert;
			}
			else {
				LinkedListNode<E> insert = new LinkedListNode<E>(value, front.getNext());
				front.setNext(insert);
			}	
		}
		else if(index == size) {
			LinkedListNode<E> insert = new LinkedListNode<E>(value);
	    	if(isEmpty()){
	    		front.setNext(insert);
	    		tail = insert;
	    	}
	    	else {
	    		tail.setNext(insert);
	    		tail = insert;
	    	} 
		}
		else { 
			LinkedListNode<E> current = front.getNext();
			
			for(int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			
			LinkedListNode<E> save = current.getNext();
			LinkedListNode<E> insert = new LinkedListNode<E>(value, save);
			current.setNext(insert);
			if(index == size) {
				tail = insert;
			}
		}
		
		size++;
		
	}

	/**
	 * Obtains the element at the specified index.
	 * @param index to get value from
	 * @return the value
	 */
	@Override
	public E get(int index) {
		checkIndex(index);
		
		LinkedListNode<E> current = front.getNext();
		
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		return current.getElement();
	}

	/**
	 * Remove value at specified index.
	 * @param index to remove at
	 * @return removed value
	 */
	@Override
	public E remove(int index) {
        checkIndex(index);
		LinkedListNode<E> current = front.getNext();
		LinkedListNode<E> save = current.getNext();
		if(index == 0) {
			if(isEmpty()) {
				return null; 
			}
			save = front.getNext();
			if(size == 1) {
				front.setNext(null);
				tail = null;
			}
			else {
				front.setNext(front.getNext().getNext());
			}
		}
		else {	
			
			for(int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			save = current.getNext();
			current.setNext(current.getNext().getNext());
			if(index == size - 1) {
				tail = current.getNext();
			}		
		}
		size--;	
		return save.getElement();
		
	}

	/**
	 * Set the element value at a specified index.
	 * @param index to set value of
	 * @param value to set
	 * @return previous value
	 */
	@Override
	public E set(int index, E value) {
		checkIndex(index);
		LinkedListNode<E> current = front.getNext();
		
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		E save = current.getElement();
		current.setElement(value);
		
		return save;
	}

	/**
	 * Obtains size of the list.
	 * @return size of list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Obtains the last element in the list.
	 * @return last element
	 */
	@Override
    public E last() {
        return tail.getElement();
    }
    
    

    /**
     * Obtains iterator for SLL.
     * @return iterator
     */
    public Iterator<E> iterator() {
        return new ElementIterator(front.getNext());
    }
	
	/**
	 * Creates an ElementIterator.
	 * @author Isabella Samuelsson
	 */
	private class ElementIterator implements Iterator<E> {
	    /** next node that will be processed */
	    private LinkedListNode<E> current;
	    /** node that was processed on the last call to 'next' */
	    private LinkedListNode<E> previous;
	    /** node to reset previous to when removing */
	    private LinkedListNode<E> previousPrevious;
	    /** if can remove */
	    private boolean removeOK;

	    /**
	     * Constructor for a ElementIterator.
	     * @param start node
	     */
	    public ElementIterator(LinkedListNode<E> start) {
	        current = start;
	        previous = front;
	        previousPrevious = front;
	    }

	    /**
	     * Determines if there is an additional element in the list.
	     * @return true/false
	     */
	    public boolean hasNext() {
	        if(getCurrent() != null) {
	        	return true;
	        }
	        return false;
	    }

	    /**
	     * Processes the next element in the list.
	     * @return the value of the processed element
	     */
	    public E next() {
	    	if(hasNext()) {
	    		previousPrevious = previous;
		    	setPrevious(current);
		    	E save = current.getElement();
		    	current = current.getNext();
		    	removeOK = true;
		    	
		        return save; 
	    	}
	    	else {
	    		throw new NoSuchElementException();
	    	}
	    	
	    }
	        
	    /**
	     * Removes the last processed element.
	     */
	    public void remove() {
	        if(isRemoveOK()) {	        	
	        	LinkedListNode<E> prev = previous;
	        	
	        	LinkedListNode<E> curr = front.getNext();
	        	int count = 0;
	        	while(curr != prev) {
	        		count++;
	        		curr = curr.getNext();
	        	}
	        	setPrevious(getPreviousPrevious());
	        	SinglyLinkedList.this.remove(count);
	        	setRemoveOK(false); 
	        }
	    }
	    
	    /**
	     * Obtains the next to be processed element.
	     * @return the next to be processed element
	     */
	    public LinkedListNode<E> getCurrent() {
	    	return current;
	    }
	    
	    /**
	     * Sets the previous node of the current node.
	     * @param set the previous node
	     */
	    public void setPrevious(LinkedListNode<E> set) {
	    	previous = set;
	    }
	    
        /**
         * Obtains the node two nodes back from the current node.
         * @return previous previous node
         */
        public LinkedListNode<E> getPreviousPrevious() {
	    	return previousPrevious;
	    }
        
        /**
         * Sets if it is okay to remove a node.
         * @param set true/false value
         */
        public void setRemoveOK(boolean set) {
        	removeOK = set;
        }
        
        /**
         * Determines if it is okay to remove a node.
         * @return true/false
         */
        public boolean isRemoveOK() {
        	return removeOK;
        }
	}
	
    /**
	 * Creates a LinkedListNode object.
	 * @author Isabella Samuelsson
	 * @param <E> type of element
	 */
	private static class LinkedListNode<E> {
	        /** value in the node */
	        private E data;
	        /** next node in the list */
	        private LinkedListNode<E> next;
	        
	       /**
	        * Constructor for LinkedListNode
	        * @param elem held in the node
	        */
	       public LinkedListNode(E elem) {
	    	   data = elem;
	    	   next = null;
	       }
	       
	       /**
	        * Constructor for LinkedListNode
	        * @param elem held in the node
	     	* @param node next node in list
	     	*/
	       public LinkedListNode(E elem, LinkedListNode<E> node) {
	    	   data = elem;
	    	   next = node;
	       }
	       
	       /**
	        * Obtains the next node.
	        * @return the next node
	     	*/
	       public LinkedListNode<E> getNext(){
	    	   return next;
	       }
	       
	       /**
	        * Sets the next node.
	        * @param node the new next node
	     	*/
	       public void setNext(LinkedListNode<E> node) {
	    	   next = node;
	       }
	       
	       /**
	        * Sets a nodes element.
	        * @param element to set
	     	*/
	       public void setElement(E elem) {
	    	   data = elem;
	       }
	       
	       /**
	        * Obtains the element.
	        * @return the element
	     	*/
	       public E getElement() {
	    	   return data;
	       }
	 }
	
}
