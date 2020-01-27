package edu.ncsu.csc316.dsa.queue;

public class ArrayBasedQueue<E> extends AbstractQueue<E>{

	private E[] data;
	private int front;
	private int rear;
	private int size;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue(int initialCapacity)
	{
		data = (E[])(new Object[initialCapacity]);
		size = 0;
	}
	
	public ArrayBasedQueue()
	{
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void enqueue(E value) {
		data[rear] = value;
		rear ++;
		
	}

	@Override
	public E dequeue() {
		E save = data[front];
		
		
		return save;
		
	}

	@Override
	public E front() {
		return data[0];
	}

	@Override
	public int size() {
		return size;
	}
	
	private void ensureCapacity(int size) {
		
	}
	

}
