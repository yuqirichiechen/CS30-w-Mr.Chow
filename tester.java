package KnightsTour;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedGrid board = new LinkedGrid(6);
		Node temp = new Node(0);
		board.display();
		board.callTour(1);

	}

}
