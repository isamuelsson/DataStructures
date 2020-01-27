package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Creates a SelectionSorter object with a null/natural ordering comparison.
	 */
	public SelectionSorter() {
		this(null);	
	}
	/**
	 * Creates a SelectionSorter object.
	 * @param comparator the comparator the sorter will use.
	 */
	public SelectionSorter(Comparator<E> comparator) {
		super(comparator);
	}
	
	/**
	 * Sorts the given objects using the comparator.
	 * @param data the objects to sort.
	 */
	@Override
	public void sort(E[] data) {
		int min;
		for(int i = 0; i < data.length; i++) {
			min = i;
			for(int j = i + 1; j < data.length; j++) {
				if(super.compare(data[j], data[min]) <= 0) {
					min = j;
				}
			}
			if(i != min){
				E x = data[i];
				data[i] = data[min];
				data[min] = x;			
			}
		}

	  }
}