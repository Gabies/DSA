package stack;

public class StackDriver {

	public static void main(String[] args) {
		ArrayStack<Integer> intStack = new ArrayStack<>(5);

		try {
			intStack.push(9);
			intStack.push(19);
			intStack.push(38);
			System.out.println(intStack.toString());
			intStack.pop();
			intStack.pop();
			System.out.println(intStack.toString());
			intStack.pop();
			intStack.pop();   //throws exception
		} catch (StackException se) {
			System.out.println(se.getMessage());
		}

		try {
			intStack.push(9);
			intStack.push(19);
			intStack.push(38);
			intStack.push(27);
			intStack.push(54);
			System.out.println(intStack.toString());
			intStack.push(98); //throws exception

		} catch (StackException se) {
			System.out.println(se.getMessage());
		}

		System.out.println("LinkedList stack");

		LListStack<String> strStack = new LListStack<>();
		for (int i = 0; i < 6; i++) {
			strStack.pushLL(Integer.toString(i));
		}
		System.out.println(strStack.toString());
              
		for (int i = 0; i < 7; i++) {
			try {
				strStack.pop();
				System.out.println(strStack.toString());
			} catch (StackException se) {
				System.out.println(se.getMessage());
			}
		}
	}
}
