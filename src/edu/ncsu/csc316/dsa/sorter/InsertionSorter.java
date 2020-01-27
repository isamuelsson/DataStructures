package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Isabella Samuelsson
 * @param <E> element type
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Creates a InsertionSorter object with a null/natural ordering comparison.
	 */
    public InsertionSorter() { 
        this(null);
    }
    /**
	 * Creates a InsertionSorter object.
	 * @param comparator the comparator the sorter will use.
	 */
    public InsertionSorter(Comparator<E> comparator) {
        super(comparator);
    }
    
    /**
	 * Sorts the given objects using the comparator.
	 * @param arr the objects to sort.
	 */
	@Override
	public void sort(E[] arr) {				
		for(int i = 1; i < arr.length; i++) {
			E x = arr[i];
			int j = i - 1;
			while(j >= 0 && super.compare(arr[j], x) == 1) {   
				arr[j + 1] = arr[j];
				j = j - 1;
				arr[j + 1] = x;
			}	
		}	
	}
}
