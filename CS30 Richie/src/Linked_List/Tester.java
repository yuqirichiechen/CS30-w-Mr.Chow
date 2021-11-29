
package Linked_List;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * LinkedList list = new LinkedList(); for (int x = 1; x < 6; x++) list.push(x);
		 * list.display(); list.pop(3); list.display();
		 */
		// System.out.println(list.find(3).getNext().getData());

		LinkedList list = new LinkedList();
		for (int x = 0; x < 6; x++) {
			list.push(x + 1);
		}
		list.display();

		list.swap(2, 5);
		list.display();

	}

}
