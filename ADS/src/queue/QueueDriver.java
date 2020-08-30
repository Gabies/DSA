package queue;

import java.util.Iterator;

public class QueueDriver {

	public static void main(String[] args) {
		CircularArrayQueue<Integer> people = new CircularArrayQueue<>();
		for (int i = 0; i < 8; i++) {
			people.enqueue(i);
		}

		Iterator<Integer> itr;
		int counter = 8;
		while (counter > 0) {
			people.dequeue();
			itr = people.iterator();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
			counter--;
		}

	}
}
