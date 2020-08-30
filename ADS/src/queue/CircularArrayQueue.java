package queue;

import java.util.Iterator;

public class CircularArrayQueue<T> implements QueueInterface<T> {

	private T[] circularQueue;
	private static final int DEFAULT_VALUE = 15;
	private int front, back, current, capacity;
	
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue() {
		this.circularQueue = (T[]) new Object[DEFAULT_VALUE];
		this.front = 0;
		this.current = 0;
		this.capacity = DEFAULT_VALUE;
		this.back = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return current == 0;
	}

	@Override
	public void enqueue(T item) {
		if (isFull()) {
			doubleSize();
		}
		back++;
		circularQueue[back % capacity] = item;
		current++;
	}

	private boolean isFull() {
		return current == capacity;
	}

	@Override
	public T dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		T frontItem = circularQueue[front % capacity];
		circularQueue[front % capacity] = null;
		front++;
		current++;
		return frontItem;
	}

	@Override
	public void clear() {
		for(int i = 0; i < capacity; i++) {
			circularQueue[i] = null;
		}
		
		front = 0;
		back = -1;
		current = 0;
	}
	
	private void doubleSize() {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[2 * capacity];
		
		for (int i = front; i <= back; i++) {
			newArray[i - front] = circularQueue[i % capacity];
		}
		
		circularQueue = newArray;
		front = 0;
		back = current - 1;
		capacity *= 2;
	}

	/***************    Iterator      *************** */

	/**
	* Obtains an Iterator object used to traverse the Queue from its front to back.
	*
	* @return an iterator.
	*
	* @throws UnsupportedOperationException if you remove using the iterator
	*/
	public Iterator<T> iterator()
	{
		return new QueueIterator( );
	}

	private class QueueIterator implements Iterator<T> {
		private int index;  //traversal index
		
		public QueueIterator() {
			this.index = front;
		}
		
		@Override
		public boolean hasNext() {
			return index <= back;
		}

		@Override
		public T next() {
			return circularQueue[(index++) % capacity];
		}
		
	}
}
