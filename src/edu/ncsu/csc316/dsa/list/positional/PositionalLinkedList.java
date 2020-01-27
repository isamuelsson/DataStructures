package edu.ncsu.csc316.dsa.list.positional;


import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * Creates a PositiionalyLinkedList object with add before, after, first and last functionality.
 * @author Isabella Samuelsson
 * @param <E> type of element
 */
public class PositionalLinkedList<E> implements PositionalList<E> {
	
	/** first element in list */
	private PositionalNode<E> front;
	/** last element in list */
	private PositionalNode<E> tail;
	/** list size */
	private int size;

	/**
	 * Creates a PositionalyLinkedList object.
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0; 
	}
	
	/**
	 * Transforms a Position to a PositionalNode.
	 * @param p the position
	 * @return the PositionalNode
	 */
	private PositionalNode<E> validate(Position<E> p) {
        if (p instanceof PositionalNode) {
            return (PositionalNode<E>) p;
        }
        throw new IllegalArgumentException("Position is not a valid positional list node.");
    }
	
	/**
	 * Creates a new position between two positions. Sets a specified value at that position.
	 * @param value at the new position
	 * @param next the position after the new position
	 * @param prev the previous position
	 * @return the new position
	 */
	private Position<E> addBetween(E value, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> insert = new PositionalNode<E>(value);
		prev.setNext(insert);
		insert.setPrevious(prev);
		insert.setNext(next);
		next.setPrevious(insert);
		size++;
		
		return (Position<E>) insert;     
    }

	/**
	 * Obtains an iterator for the list.
	 * @return iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}

	/**
	 * Adds an element after a specified position
	 * @param p the position to add after
	 * @param value to add
	 * @return the new position created
	 */
	@Override
	public Position<E> addAfter(Position<E> p, E value) {
		PositionalNode<E> prev = validate(p);
		PositionalNode<E> next = prev.getNext();

		return addBetween(value, next, prev);
	}

	/**
	 * Adds an element before a specified position
	 * @param p the position to add after
	 * @param value to add
	 * @return the new position created
	 */
	@Override
	public Position<E> addBefore(Position<E> p, E value) {
		PositionalNode<E> next = validate(p);
		PositionalNode<E> prev = next.getPrevious();

		return addBetween(value, next, prev);
	}

	/**
	 * Adds an element at the beginning of the list
	 * @param value to add
	 * @return the new position created
	 */
	@Override
	public Position<E> addFirst(E value) {	
		return addBetween(value, front.getNext(), front);
	}

	/**
	 * Adds an element at the end of the list
	 * @param value to add
	 * @return the new position created
	 */
	@Override
	public Position<E> addLast(E value) {
		return addBetween(value, tail, tail.getPrevious());
	}

	/**
	 * Returns the position after a specified position
	 * @param p the initial position
	 * @return the position after
	 */
	@Override
	public Position<E> after(Position<E> p) {
		PositionalNode<E> node = validate(p);
		if(node.getNext() != null) {
			return (Position<E>) node.getNext();     //correct?
		}
		throw new NoSuchElementException();
	}

	/**
	 * Returns the position before a specified position
	 * @param p the initial position
	 * @return the position before
	 */
	@Override
	public Position<E> before(Position<E> p) {
		PositionalNode<E> node = validate(p);
		if(node.getPrevious() != null) {
			return (Position<E>) node.getPrevious();     //correct?
		}
		throw new NoSuchElementException();
	}

	/**
	 * Returns the first position in a list
	 * @return the first position
	 */
	@Override 
	public Position<E> first() {
		if(front.getNext().getElement() != null) { 
			return (Position<E>) front.getNext();     //correct?
		}
		throw new NoSuchElementException();
	}

	/**
	 * Determines if the list is empty
	 * @return true/false
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true; 
		}
		return false;
	}

	/**
	 * Returns the last position in a list
	 * @return the last position
	 */
	@Override
	public Position<E> last() {
		if(tail.getPrevious() != null) {
			return (Position<E>) tail.getPrevious();     //correct?
		}
		throw new NoSuchElementException();
	}

	/**
	 * Returns an Iterable object
	 * @return an Iterable object
	 */
	@Override
	public Iterable<Position<E>> positions() { 
		return new PositionIterable(); 
	}

	/**
	 * Removes the specified position from the list.
	 * @param p the position to remove
	 * @return the removed element at the position
	 */
	@Override
	public E remove(Position<E> p) {
		PositionalNode<E> node = validate(p); 
		E save = node.getElement();
		PositionalNode<E> after = node.getNext();
		node.getPrevious().setNext(after);
		after.setPrevious(node.getPrevious());
		size--;
		node.setNext(null);
		node.setPrevious(null);
		return save;
	}

	/**
	 * Sets a new value at a specified position.
	 * @param p the position to set
	 * @param value the new value
	 * @return the previous value
	 */
	@Override
	public E set(Position<E> p, E value) {
		PositionalNode<E> node = validate(p);
		E save = node.getElement();
		node.setElement(value);
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
     * Creates a PositionIterable.
     * @author Isabella Samuelsson
     */
    private class PositionIterable implements Iterable<Position<E>> {
        
        /**
         * Creates an iterator object.
         * @return iterator object
         */
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator(front.getNext());
        }
    } 

	/**
	 * Creates a positional node for the Positionaly Linked List.
	 * @author Isabella Samuelssson
	 * @param <E> the type of element
	 */
	private static class PositionalNode<E> implements Position<E> {
		/** value in the node */
        private E element;
        /** next node in list */
        private PositionalNode<E> next;
        /** previous node in list */
        private PositionalNode<E> previous;

        /**
         * Creates a PositionalNode.
         * @param value at the position
         */
        public PositionalNode(E value) {
            this(value, null);
        }

        /**
         * Creates a PositionalNode.
         * @param value at the position
         * @param next node in the list
         */
        public PositionalNode(E value, PositionalNode<E> next) {
            this(value, next, null);
        }

        /**
         * Creates a PositionalNode.
         * @param value at the position
         * @param next node in the list
         * @param prev node in the list
         */
        public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
            setElement(value);
            setNext(next);
            setPrevious(prev);
        }

        /**
         * Sets the node that is previous to the caller node
         * @param prev node in the list
         */
        public void setPrevious(PositionalNode<E> prev) {
            previous = prev;
        }

        /**
         * Obtains the previous node in the list.
         * @return the previous node
         */
        public PositionalNode<E> getPrevious() {
            return previous;
        }
        
        /**
         * Sets the next node to the caller node.
         * @param next node
         */
        public void setNext(PositionalNode<E> next) {
            this.next = next;
        }

        /**
         * Obtains the next node in the list.
         * @return next node
         */
        public PositionalNode<E> getNext() {
            return next;
        }

        /**
         * Obtain the element in the node.
         * @return the element
         */
        @Override
        public E getElement() {
            return element;
        }
        
        /**
         * Sets the node's value.
         * @param element to set
         */
        public void setElement(E element) {
            this.element = element;
        }
    }
	
	/**
	 * Creates a PositionIterator object.
	 * @author Isabella Samuelsson
	 */
	private class PositionIterator implements Iterator<Position<E>> {
		/** current position of the iterator */
        private Position<E> current;
        /** if ok to remove element */
        private boolean removeOK;

        /**
         * Creates a PositionIterator starting at a specific position.
         * @param start position
         */
        public PositionIterator(PositionalNode<E> start) {
        	current = start;
 	        removeOK = false;
        }

        /**
         * Determines if there is another node in the list.
         * @return true/false
         */
        @Override
        public boolean hasNext() {
            if(current == null) {
            	return false;
            }
            return true;
        }

        /**
         * The position after the current position.
         * @return the next position
         */
        @Override
        public Position<E> next() {
        	if(hasNext()) {
        		
		    	Position<E> save = current;
		    	current = validate(save).getNext();
		    	removeOK = true;
		    	
		        return save;
	    	}
	    	else {
	    		throw new NoSuchElementException();
	    	}
        }

        /**
         * Removes the last iterated over position.
         */
        @Override
        public void remove() {
        	if(removeOK) {	        	
	        	PositionalLinkedList.this.remove(validate(current).getPrevious());
	        	removeOK = false; 
	        }
        	else {
        		throw new IllegalStateException();
        	}
        }
    }
	
	
	
	/**
	 * Creates an ElementIteratoe object.
	 * @author Isabella Samuelsson
	 */
	private class ElementIterator implements Iterator<E> {

        /** Iterator object */
        private Iterator<Position<E>> it;

        /**
         * Creates a ElementIterator starting at a specific position.
         * @param start position
         */
        public ElementIterator(PositionalNode<E> start) {
            it = new PositionIterator(start);
        }

        /**
         * Determines if there is another element in the list.
         * @return true/false
         */
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        /**
         * The element after the current element.
         * @return the next element
         */
        @Override
        public E next() {
            return it.next().getElement();
        }
        
        /**
         * Removes the last iterated over position.
         */
        @Override
        public void remove() {
            it.remove();
        }
    }

}
