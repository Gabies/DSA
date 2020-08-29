package stack;

public class ArrayStack<T> implements StackInterface<T> {

	private T[] stack;
	private static final int DEFAULT_VALUE = 15;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initValue) {
		if (initValue <= 0) {
			this.stack = (T[]) new Object[DEFAULT_VALUE];
		} else {
			this.stack = (T[]) new Object[initValue];
		}
		top = -1;
	}

	public ArrayStack() {
		this(DEFAULT_VALUE);
	}
	
	@Override
	public void push(T item) throws StackException{
		top++;
		if (top < stack.length) {
			stack[top] = item;
		} else {
			throw new StackException("Stack overflow");
		}
	}
	
	@Override
	public T pop() throws StackException{
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		
		T temp = this.peek();
		top--;
		return temp;
	}
	
	@Override
	public boolean isEmpty() {
		  return (top == -1);
	}
	
	@Override
	public T peek() throws StackException{
		if (isEmpty()) {
			throw new StackException("No items in stack to peek on");
		} 
		return stack[top];
	}

	@Override
	public void clear() {
		for (int i = 0; i < stack.length; i++) {
			stack[i] = null;
		}
	}
	
	public String toString() {
		if (isEmpty()) {
			return "[ ]";
		}
		
		StringBuffer output = new StringBuffer("[");
		for (T item : stack) {
			output.append(item + " ");
		}
		output.append("]");
		return output.toString();
	}
}
