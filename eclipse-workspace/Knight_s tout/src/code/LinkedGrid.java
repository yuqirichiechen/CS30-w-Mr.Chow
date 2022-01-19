package code;

public class LinkedGrid {
	private Node first;
	private int length, width;
	private int dimension;

	
	public LinkedGrid(int dimension) {
		length = dimension;
		width = dimension;
		this.dimension = dimension;
		
		if(dimension > 0)
		{
			
			first = new Node(0);
			Node columnMarker = first;
			Node rowMarker = first;
			
			for(int x = 0; x < width-1; x++)
			{				
				columnMarker.setRight(new Node(0));
				columnMarker.getRight().setLeft(columnMarker);
				columnMarker = columnMarker.getRight();
			}
			
			for(int x = 0; x < length - 1; x++)
			{
				rowMarker.setDown(new Node(0));
				rowMarker.getDown().setUp(rowMarker);
				
				rowMarker = rowMarker.getDown();
				columnMarker = rowMarker;
				
				for(int y = 0; y < width-1; y++)
				{
					columnMarker.setRight(new Node(0));
					columnMarker.getRight().setLeft(columnMarker);
					columnMarker.getRight().setUp(columnMarker.getUp().getRight());
					columnMarker.getRight().getUp().setDown(columnMarker.getRight());
					columnMarker= columnMarker.getRight();
				}
			}
		}
		
		
		Node temp = first;
		Node rowMarker = first;
		
		while(temp != null)
		{
			while(temp != null)
			{
				try {temp.setPath1(temp.getUp().getUp().getLeft());} catch(Exception e) {};
				try {temp.setPath2(temp.getUp().getUp().getRight());} catch(Exception e) {};
				try {temp.setPath3(temp.getUp().getRight().getRight());} catch(Exception e) {};
				try {temp.setPath4(temp.getDown().getRight().getRight());} catch(Exception e) {};
				try {temp.setPath5(temp.getDown().getDown().getRight());} catch(Exception e) {};
				try {temp.setPath6(temp.getDown().getDown().getLeft());} catch(Exception e) {};
				try {temp.setPath7(temp.getUp().getLeft().getLeft());} catch(Exception e) {};
				try {temp.setPath8(temp.getDown().getLeft().getLeft());} catch(Exception e) {};
				temp = temp.getRight();
				
			}
			
			rowMarker = rowMarker.getDown();
			temp=rowMarker;
		}
		
	}
	
	
	public void tour() {
		tour(first,1);
	}
	
	public void tour(Node current, int number) {
		current.setData(number);
		
		if(number == dimension*dimension)
			display();
		
		if(current.getPath1()!=null && current.getPath1().getData() == 0 )
			tour(current.getPath1(), number+1);
		if(current.getPath2()!=null && current.getPath2().getData() == 0 )
			tour(current.getPath2(), number+1);
		if(current.getPath3()!=null && current.getPath3().getData() == 0 )
			tour(current.getPath3(), number+1);
		if(current.getPath4()!=null && current.getPath4().getData() == 0 )
			tour(current.getPath4(), number+1);
		if(current.getPath5()!=null && current.getPath5().getData() == 0 )
			tour(current.getPath5(), number+1);
		if(current.getPath6()!=null && current.getPath6().getData() == 0 )
			tour(current.getPath6(), number+1);
		if(current.getPath7()!=null && current.getPath7().getData() == 0 )
			tour(current.getPath7(), number+1);
		if(current.getPath8()!=null && current.getPath8().getData() == 0 )
			tour(current.getPath8(), number+1);
		
		current.setData(0);
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
	
}
