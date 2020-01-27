package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * @author Isabella Samuelsson
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {

	@Override
	public void sort(E[] data) {
		int max = 0;
		for(int i = 0; i < data.length; i++) {
			max = Math.max(max, data[i].getId());
		}
		double x = Math.ceil(Math.log(max + 1) / Math.log(10));
		
		int p = 1;
		for(int j = 1; j < x + 1; j++) {
			int[] b = new int[10];
			for(int i = 0; i < data.length; i++) {
				b[(data[i].getId() / p) % 10] = b[(data[i].getId() / p) % 10] + 1;
			}
			for(int i = 1; i < 10; i++) {
				b[i] = b[i - 1] + b[i];
			}
			
			E[] f = data.clone();
			for(int i = data.length - 1; i > -1; i--) {
				f[b[(data[i].getId() / p) % 10] - 1] = data[i];
				b[(data[i].getId() / p ) % 10] = b[(data[i].getId() / p) % 10] - 1;
			}
			
			for(int i = 0; i < data.length; i++) {
				data[i] = f[i];
			}
			
			p *= 10;				
		}
		
	}
	
}
