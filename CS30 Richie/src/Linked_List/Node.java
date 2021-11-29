package Linked_List;

public class Node {
	private int intData;
	private Node prevNode;
	private Node nextNode;

	public Node(int data) {
		this.intData = data;
	}

	public int getData() {
		return this.intData;
	}

	public void setPrev(Node prev) {
		this.prevNode = prev;
	}

	public Node getPrev() {
		return this.prevNode;
	}

	public void setNext(Node next) {
		this.nextNode = next;
	}

	public Node getNext() {
		return this.nextNode;
	}

}