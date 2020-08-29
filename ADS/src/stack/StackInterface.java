package stack;

public interface StackInterface<T> {
	
	public void push(T item) throws StackException;
	public T pop() throws StackException;
	public boolean isEmpty();
	public T peek() throws StackException;
	public void clear();
}
