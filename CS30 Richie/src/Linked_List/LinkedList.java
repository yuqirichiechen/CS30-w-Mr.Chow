package Linked_List;

public class LinkedList {

	private Node first;
	private Node last;
	private int size;

	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}

	public void push(int data) {
		Node temp = new Node(data);

		if (first == null)
			first = temp;
		else
			last.setNext(temp);

		temp.setPrev(last);
		last = temp;

		size++;
	}

	public void display() {
		if (first != null) {
			Node temp = first;

			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}

			System.out.println();

			temp = last;

			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getPrev();
			}

			System.out.println();
		}

		else
			System.out.println("The list is empty");
	}

	public void pop(int data) {
		Node temp = find(data);

		if (temp != first && temp != last) {
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
		}

		if (temp == first && temp.getNext() != null) {
			first = first.getNext();
			first.setPrev(null);
		}

		if (temp == last) {
			pop();
		}

	}

	public void pop() {
		if (size >= 2) {
			last = last.getPrev();
			last.setNext(null);
			size--;
		}

		else if (size == 1) {
			first = null;
			last = null;
			size--;
		}
	}

	public Node find(int target) {
		Node temp = first;
		while (temp != null) {
			if (temp.getData() == target)
				return temp;
			temp = temp.getNext();
		}

		return null;
	}

	public void swap(int number1, int number2) {
		Node node1 = find(number1);
		Node node2 = find(number2);

		if (node1 != null && node2 != null && node1 != node2) {
			boolean correctRelativePosition = false;
			Node temp = node1;
			int distance = 0;
			while (temp != null) {
				if (temp == node2) {
					correctRelativePosition = true;
					break;
				}
				temp = temp.getNext();
			}

			if (!correctRelativePosition) {
				temp = node1;
				node1 = node2;
				node2 = temp;
			}

			// count the distance between the nodes
			temp = node1;
			while (temp != null) {
				if (temp == node2) {
					break;
				}
				temp = temp.getNext();
				distance++;
			}

			if (node1 == first && node2 == last) {
				node1.getNext().setPrev(node2);
				node2.getPrev().setNext(node1);
				first = node2;
				first.setNext(node1.getNext());
				node1.setNext(null);
				last = node1;
				last.setPrev(node2.getPrev());
				node2.setPrev(null);
			}

			// Next to each other
			else if (distance == 1) {

				if (node1 == first) {
					node1.setNext(node2.getNext());
					node2.getNext().setPrev(node1);
					node2.setPrev(null);
					node2.setNext(node1);
					node1.setPrev(node2);
					first = node2;
				}

				else if (node2 == last) {
					node2.setPrev(node1.getPrev());
					node2.setNext(node1);
					node1.getPrev().setNext(node2);
					node1.setNext(null);
					node1.setPrev(node2);
					last = node1;
				}

				else if (node1 != first && node2 != last) {
					node1.getPrev().setNext(node2);
					node2.getNext().setPrev(node1);
					node1.setNext(node2.getNext());
					node2.setPrev(node1.getPrev());
					node1.setPrev(node2);
					node2.setNext(node1);
				}

			}

			// one extra node between them
			else if (distance == 2) {

				if (node1 == first) {
					node1.getNext().setPrev(node2);
					node1.getNext().setNext(node1);
					node2.getNext().setPrev(node1);
					node1.setNext(node2.getNext());
					node1.setPrev(node2.getPrev());
					node2.setNext(node2.getPrev());
					node2.setPrev(null);
					first = node2;
				}

				else if (node2 == last) {
					node1.getNext().setNext(node1);
					node1.getNext().setPrev(node2);
					node1.getPrev().setNext(node2);
					node2.setNext(node2.getPrev());
					node2.setPrev(node1.getPrev());
					node1.setPrev(node1.getNext());
					node1.setNext(null);
					last = node1;
				}

				else if (node1 != first && node2 != last) {
					node1.getPrev().setNext(node2);
					node1.getNext().setNext(node1);
					node1.getNext().setPrev(node2);
					node2.getNext().setPrev(node1);
					node2.setPrev(node1.getPrev());
					node1.setPrev(node1.getNext());
					node1.setNext(node2.getNext());
					node2.setNext(node1.getPrev());
				}

			}

			// two or more extra nodes between them
			else if (distance >= 3) {

				if (node1 == first) {
					node1.getNext().setPrev(node2);
					node2.getPrev().setNext(node1);
					node2.getNext().setPrev(node1);
					node1.setPrev(node2.getPrev());
					node1.setNext(node2.getNext());
					node2.setNext(node2.getPrev().getPrev());
					node2.setPrev(null);
					first = node2;
				}

				else if (node2 == last) {
					node1.getPrev().setNext(node2);
					node1.getNext().setPrev(node2);
					node2.getPrev().setNext(node1);
					node2.setNext(node1.getNext());
					node2.setPrev(node1.getPrev());
					node1.setPrev(node1.getNext().getNext());
					node1.setNext(null);
					last = node1;
				}

				else if (node1 != first && node2 != last) {
					node1.getPrev().setNext(node2);
					node1.getNext().setPrev(node2);
					node2.getPrev().setNext(node1);
					node2.getNext().setPrev(node1);
					node1.setNext(node2.getNext());
					node2.setNext(node2.getPrev().getPrev());
					node2.setPrev(node1.getPrev());
					node1.setPrev(node2.getNext().getNext());
				}
			}
		}
	}

}
