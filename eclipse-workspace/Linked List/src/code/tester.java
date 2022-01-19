package code;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		for(int x = 0; x < 6; x++)
		{
			list.push(x+1);
		}
		list.display();
		
		list.swap(2, 5);
		list.display();

	}

}