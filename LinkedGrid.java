package KnightsTour;

public class LinkedGrid {

	private Node topLeft;

	private int dimension;

	private int count = 0;

	public LinkedGrid(int dimension) {

		this.dimension = dimension;

		topLeft = new Node(0);

// building the top row

		Node columnMarker = topLeft;

		for (int x = 0; x < dimension - 1; x++) {
			Node temp = new Node(0);

			temp.setLeft(columnMarker);

			columnMarker.setRight(temp);

			columnMarker = temp;
		}

// building the next row down

		Node rowMarker = topLeft;

		for (int y = 0; y < dimension - 1; y++) {

// the first node in the row

			Node temp = new Node(0);

			columnMarker = temp;

			temp.setUp(rowMarker);

			rowMarker.setDown(temp);

// make the rest of the row

			for (int x = 0; x < dimension - 1; x++) {

				temp = new Node(0);

				temp.setLeft(columnMarker);

				columnMarker.setRight(temp);

				temp.getLeft().getUp().getRight().setDown(temp);

				temp.setUp(temp.getLeft().getUp().getRight());

				columnMarker = temp;

			}
			while (temp != null) {
				while (temp != null) {
					try {
						temp.setPath1(temp.getUp().getUp().getLeft());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath2(temp.getUp().getUp().getRight());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath3(temp.getUp().getRight().getRight());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath4(temp.getDown().getRight().getRight());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath5(temp.getDown().getDown().getRight());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath6(temp.getDown().getDown().getLeft());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath7(temp.getUp().getLeft().getLeft());
					} catch (Exception e) {
					}
					;
					try {
						temp.setPath8(temp.getDown().getLeft().getLeft());
					} catch (Exception e) {
					}
					;
					temp = temp.getRight();

				}
			}
			rowMarker = rowMarker.getDown();

		}
	}

	public void callTour(int x) {

		tour(topLeft, x);

	}

	public void tour(Node temp, int x) {

		temp.setData(x);

		if (temp.getUp() != null && temp.getUp().getUp() != null && temp.getUp().getUp().getLeft() != null
				&& temp.getUp().getUp().getLeft().getData() == 0) {
// if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
// else {

//temp = temp.getPath1();
//System.out.println("1");
			tour(temp.getPath1(), (x + 1));

// }
		}
		if (temp.getUp() != null && temp.getUp().getUp() != null && temp.getUp().getUp().getRight() != null
				&& temp.getUp().getUp().getRight().getData() == 0) {

// if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
// else {
//temp = temp.getPath2();
//System.out.println("2");
			tour(temp.getPath2(), (x + 1));
// }
		}
		if (temp.getRight() != null && temp.getRight().getRight() != null && temp.getRight().getRight().getUp() != null
				&& temp.getRight().getRight().getUp().getData() == 0) {

//if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
//else {
//temp = temp.getPath3();
//System.out.println("3");
			tour(temp.getPath3(), (x + 1));
// }
		}
		if (temp.getRight() != null && temp.getRight().getRight() != null
				&& temp.getRight().getRight().getDown() != null
				&& temp.getRight().getRight().getDown().getData() == 0) {

//if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
//tour(temp, (x + 1));
//}
//else {
//temp = temp.getPath4();
//System.out.println("4");
			tour(temp.getPath4(), (x + 1));
//}
		}
		if (temp.getDown() != null && temp.getDown().getDown() != null && temp.getDown().getDown().getRight() != null
				&& temp.getDown().getDown().getRight().getData() == 0) {

// if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
// else {
// temp = temp.getPath5();
//System.out.println("5");
			tour(temp.getPath5(), (x + 1));
// }
		}
		if (temp.getDown() != null && temp.getDown().getDown() != null && temp.getDown().getDown().getLeft() != null
				&& temp.getDown().getDown().getLeft().getData() == 0) {

// if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
// else {
// temp = temp.getPath6();
// System.out.println("6");
			tour(temp.getPath6(), (x + 1));
// }
		}
		if (temp.getLeft() != null && temp.getLeft().getLeft() != null && temp.getLeft().getLeft().getDown() != null
				&& temp.getLeft().getLeft().getDown().getData() == 0) {

// if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
//else {
// temp = temp.getPath7();
// System.out.println("7");
			tour(temp.getPath7(), (x + 1));
// }
		}
		if (temp.getLeft() != null && temp.getLeft().getLeft() != null && temp.getLeft().getLeft().getUp() != null
				&& temp.getLeft().getLeft().getUp().getData() == 0) {

// if(temp.getPath1() != null && temp.getPath1().getData() != 0 && temp.getPath2() != null && temp.getPath2().getData() != 0 && temp.getPath3() != null && temp.getPath3().getData() != 0 && temp.getPath4() != null && temp.getPath4().getData() != 0 && temp.getPath5() != null && temp.getPath5().getData() != 0 && temp.getPath6() != null && temp.getPath6().getData() != 0 && temp.getPath7() != null && temp.getPath7().getData() != 0 && temp.getPath8() != null && temp.getPath8().getData() != 0) {
// tour(temp, (x + 1));
// }
// else {
// temp = temp.getPath8();
// System.out.println("8");
			tour(temp.getPath8(), (x + 1));
// }
		}

		temp.setData(0);

		if (x == (dimension * dimension)) {
			display();
			System.out.println("");
			count++;
			System.out.println(count);
		}
	}

	public void display() {

		Node temp = topLeft;

		Node rowMarker = topLeft;

		while (temp != null) {

			while (temp != null) {

				System.out.print(temp.getData() + " ");

				if (temp.getData() < 10)
					System.out.print(" ");

				temp = temp.getRight();

			}

			temp = rowMarker.getDown();

			rowMarker = rowMarker.getDown();

			System.out.println();
		}
	}

	public void flood(int data) {

		Node temp = topLeft;

		while (temp != null) {

			if (temp.getData() != data) {

				int old = temp.getData();

				temp.setData(data);
				if (temp.getRight() != null)
					if (temp.getRight().getData() == old) {
						old = temp.getData();

						temp.getRight().setData(data);
						flood(temp.getRight().getData());
// temp = temp.getRight();
					}
				if (temp.getLeft() != null)
					if (temp.getLeft().getData() == old) {
						old = temp.getData();

						temp.getLeft().setData(data);
						flood(temp.getLeft().getData());
// temp = temp.getLeft();
					}
				if (temp.getUp() != null)
					if (temp.getUp().getData() == old) {
						old = temp.getData();

						temp.getUp().setData(data);
						flood(temp.getUp().getData());
// temp = temp.getUp();
					}
				if (temp.getDown() != null)
					if (temp.getDown().getData() == old) {
						old = temp.getData();

						temp.getDown().setData(data);
						flood(temp.getDown().getData());
// temp = temp.getDown();
					}

			}
			temp = null;
		}

	}
}