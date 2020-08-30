package queue;

public interface QueueInterface<T> {
	
	public boolean isEmpty();
	public void enqueue(T item);
	public T dequeue() throws QueueException;
	public void clear();
	
}
