package stack;

public class LListStack<T> implements StackInterface<T> {

	private Node<T> top;

	public LListStack() {
		top = null;
	}

	@Override
	public void push(T item) throws StackException {
		// depricated for LinkedList since there is no maximum cap
	}
	
	public void pushLL(T item) {
		if (isEmpty()) {
			top = new Node<T>(item, null);
		} else {
			top = new Node<T>(item,top);
		}
	}

	@Override
	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		T temp = top.val;
		top = top.next;
		return temp;
	}

	@Override
	public boolean isEmpty() {

		return top == null;
	}

	@Override
	public T peek() throws StackException {

		return top.val;
	}

	@Override
	public void clear() {
		top = null;
	}

	public String toString() {
		if (isEmpty()) {
			return "[ ]";
		}
		StringBuffer output = new StringBuffer("[");
		Node<T> temp = top;  //keep top pointer at the top otherwise it will be pointing to null(end) without popping items
		while (temp != null) {
			output.append(temp.val + " ");
			temp = temp.next;
		}
		output.append("]");
		
		return output.toString();
	}

	private class Node<U> {
		private U val;
		private Node<U> next;

		private Node(U val) {
			this(val, null);
		}

		private Node(U val, Node<U> node) {
			this.val = val;
			this.next = node;
		}
	}
}
