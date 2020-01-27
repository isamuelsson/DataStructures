package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * @author Dr. King
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
	/**
	 * Sorts the given objects.
	 * @param data the objects to sort.
	 */
	@Override
	public void sort(E[] data) {
		int min = data[0].getId();
		int max = data[0].getId();
		for(int i = 0; i < data.length; i++) {
			if(min > data[i].getId()) {
				min = data[i].getId();
			}
			if(max < data[i].getId()) {
				max = data[i].getId();
			}
		}
		int k = max - min + 1;
		
		int[] b = new int[k];
		for(int i = 0; i < data.length; i++) {
			b[data[i].getId() - min] = b[data[i].getId() - min] + 1;
		}
		for(int i = 1; i < k; i++) {
			b[i] = b[i - 1] + b[i];
		}
		
		E[] f = data.clone(); 
		for(int i = 0; i < data.length; i++) {
			f[b[data[i].getId() - min] - 1] = data[i];
			b[data[i].getId() - min] = b[data[i].getId() - min] - 1;
		}
		for(int i = 0; i < data.length; i++) {
			data[i] = f[i];
		}
		
		
	}	
}
