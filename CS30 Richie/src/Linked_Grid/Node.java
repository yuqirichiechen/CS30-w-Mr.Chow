package Linked_Grid;

public class Node {

	private Node up, down, left, right;
	private int data;
	private boolean filled;

	public Node(int i) {
		data = i;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isFull() {
		return filled;
	}

	public void setFull(boolean filled) {
		this.filled = filled;
	}

}
