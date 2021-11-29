package KnightsTour;

public class Node {

	private int data;

	private Node up, down, left, right, path1, path2, path3, path4, path5, path6, path7, path8;

	public Node getPath1() {
		return up.up.left;
	}

	public void setPath1(Node path1) {
		this.path1 = path1;
	}

	public Node getPath2() {
		return up.up.right;
	}

	public void setPath2(Node path2) {
		this.path2 = path2;
	}

	public Node getPath3() {
		return right.right.up;
	}

	public void setPath3(Node path3) {
		this.path3 = path3;
	}

	public Node getPath4() {
		return right.right.down;
	}

	public void setPath4(Node path4) {
		this.path4 = path4;
	}

	public Node getPath5() {
		return down.down.right;
	}

	public void setPath5(Node path5) {
		this.path5 = path5;
	}

	public Node getPath6() {
		return down.down.left;
	}

	public void setPath6(Node path6) {
		this.path6 = path6;
	}

	public Node getPath7() {
		return left.left.down;
	}

	public void setPath7(Node path7) {
		this.path7 = path7;
	}

	public Node getPath8() {
		return left.left.up;
	}

	public void setPath8(Node path8) {
		this.path8 = path8;
	}

	public Node(int data) {

		this.data = data;
	}

	public Node() {

		this.data = ((int) (Math.random() * 6));
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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

}