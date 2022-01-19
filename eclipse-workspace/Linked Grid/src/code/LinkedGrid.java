package code;

public class LinkedGrid {
	private Node first;
	private int length, width;
	
	public LinkedGrid(int length, int width) {
		this.length = length;
		this.width = width;
		Node columnMarker = null;
		Node rowMarker = null;
		
		
		for(int x = 0; x < width; x++)
		{
			Node temp = new Node((int)(Math.random()*(6)+1));
			
			if(first == null)
			{
				first = temp;
				columnMarker = first;
				rowMarker = first;
			}
			else
			{
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				columnMarker = temp;
			}
		}
		
		for(int x = 0; x < length - 1; x++)
		{
			rowMarker.setDown(new Node((int)(Math.random()*(6)+1)));
			rowMarker.getDown().setUp(rowMarker);
			
			rowMarker = rowMarker.getDown();
			columnMarker = rowMarker;
			
			for(int y = 0; y < width-1; y++)
			{
				columnMarker.setRight(new Node((int)(Math.random()*(6)+1)));
				columnMarker.getRight().setLeft(columnMarker);
				columnMarker.getRight().setUp(columnMarker.getUp().getRight());
				columnMarker.getRight().getUp().setDown(columnMarker.getRight());
				columnMarker= columnMarker.getRight();
			}
		}
		
	/*	
		Node temp = new Node((int)(Math.random()*(6)+1));
		columnMarker = temp;
		temp.setUp(rowMarker);
		rowMarker.setDown(temp);
		rowMarker = temp;
		
		for(int x = 0; x < width-1; x++)
		{
			temp = new Node((int)(Math.random()*(6)+1));
			temp.setLeft(columnMarker);
			columnMarker.setRight(temp);
			temp.setUp(temp.getLeft().getUp().getRight());
			temp.getUp().setDown(temp);
			columnMarker = temp;
		}
		*/
	}
	
	public Node first() {
		return first;
	}

	
	public void display() {
		Node temp = first;
		Node rowMarker = first;
		
		while(rowMarker!=null)
		{
			while(temp != null)
			{
				System.out.print(temp.getData() + " ");
				temp = temp.getRight();
			}
			temp = rowMarker.getDown();
			rowMarker = temp;
			System.out.println();
		}
		System.out.println();
		
	}
		
	public boolean complete() {
		Node temp = first;
		Node rowMarker = first.getDown();
		int firstData = first.getData();
		
		while(temp!=null)
		{
			while(temp != null)
			{
				if(temp.getData()!= firstData)
					return false;
				temp = temp.getRight();
			}
			
			temp = rowMarker;
			if(rowMarker != null)
				rowMarker = rowMarker.getDown();
		}
		return true;

	}

}
