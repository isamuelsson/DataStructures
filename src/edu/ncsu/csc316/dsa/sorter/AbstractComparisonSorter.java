package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
/**
 * Abstract class for comparison sorters.
 * @author Isabella Samuelsson
 * @param <E> the element type to sort
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {
	/* Comparator used */ 
    private Comparator<E> comparator;
    
    /**
     * Creates a comparison sorter object.
     * @param comparator the comparator used
     */
    public AbstractComparisonSorter(Comparator<E> comparator) {
        setComparator(comparator);
    }
    
    /**
     * Sets a comparator.
     * @param comparator the comparator to set
     */
    private void setComparator(Comparator<E> comparator) {
        if(comparator == null) {
           comparator = new NaturalOrder();
        }
        this.comparator = comparator;
    }     
    
    /**
     * Acts as a natural order comparator when no comparator is specified.
     * @author Isabella Samuelsson
     */
    private class NaturalOrder implements Comparator<E> {
        public int compare(E first, E second) {
            return ((Comparable<E>) first).compareTo(second);
        }
    }
    
    /**
     * Compares two objects.
     * @param data1 to compare
     * @param data2 to compare
     * @return the order
     */
    public int compare(E data1, E data2) {
        return comparator.compare(data1,  data2);
    }
}
