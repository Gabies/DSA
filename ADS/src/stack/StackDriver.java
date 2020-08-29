package stack;

public class StackDriver {

	public static void main(String[] args) {
		ArrayStack<Integer> intStack = new ArrayStack<>(5);
		ArrayStack<String> strStack = new ArrayStack<>(5);
		
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
	}
}
