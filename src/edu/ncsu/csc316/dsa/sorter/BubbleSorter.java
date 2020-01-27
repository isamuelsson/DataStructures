package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Uses the BubbleSort method to sort objects.
 * @author Isabella Samuelsson
 * @param <E> the type to sort
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Creates a BubbleSorter object.
	 * @param comparator the comparator the sorter will use.
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}
	
	/**
	 * Creates a BubbleSorter object with a null/natural ordering comparison.
	 */
	public BubbleSorter() {
		this(null);
	}

	/**
	 * Sorts the given objects using the comparator.
	 * @param arr the objects to sort.
	 */
	@Override
	public void sort(E[] arr) {					
		boolean r = true;
		while(r) {
			r = false;
			for(int i = 1; i < arr.length; i++) {
				if(super.compare(arr[i] , arr[i - 1]) < 0) {
					E x = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = x;
					r = true;
				}
			}
		}
	}
}
