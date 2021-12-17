package Linked_Grid;

import java.util.Scanner;

public class FloodProgram {

	
	public static void populate(Node root, int data) {
	    root.setData(data);

	    // Fill down
	    if (root.getDown() != null) {
	        if (!root.getDown().isFull() && root.getDown().getData() == data) {
	            root.getDown().setFull(true);
	            populate(root.getDown(), data);

	        } else if (root.getDown().isFull() && root.getDown().getData() != data) {
	        	populate(root.getDown(), data);
	        }
	    }
	    // Fill right
	    if (root.getRight() != null) {
	        if (!root.getRight().isFull() && root.getRight().getData() == data) {
	            root.getRight().setFull(true);
	            populate(root.getRight(), data);

	        } else if (root.getRight().isFull() && root.getRight().getData() != data) {
	        	populate(root.getRight(), data);
	        }
	    }
	    // Fill left
	    if (root.getLeft() != null) {
	        if (!root.getLeft().isFull() && root.getLeft().getData() == data) {
	            root.getLeft().setFull(true);
	            populate(root.getLeft(), data);

	        } else if (root.getLeft().isFull() && root.getLeft().getData() != data) {
	        	populate(root.getLeft(), data);
	        }
	    }
	    // Fill up
	    if (root.getUp() != null) {
	        if (!root.getUp().isFull() && root.getUp().getData() == data) {
	            root.getUp().setFull(true);
	            populate(root.getUp(), data);

	        } else if (root.getUp().isFull() && root.getUp().getData() != data) {
	        	populate(root.getUp(), data);
	        }
	    }

	}
	
	public static void populateOnce1(Node temp, int x)
	{
		if(temp.getLeft()!=null && temp.getLeft().getData() == temp.getData())
			populateOnce1(temp.getLeft(), x);
		
		temp.setData(x);
	}
	
	public static void populateOnce2(Node temp, int x)
	{
		if(temp.getUp()!=null && temp.getUp().getData() == temp.getData())
			populateOnce2(temp.getUp(), x);
		
		temp.setData(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		String again = "";
		do
		{
			LinkedGrid board = new LinkedGrid(10,10);
			int chance = 300;
			
			do
			{
				board.display();
				System.out.println("You have " + chance + "/30 chances left");
				System.out.println("Choose a number");
				int mark = input.nextInt();
				populate(board.first(), mark);
				
				chance--;
			}while(board.complete() == false && chance >= 0);
			
			if(board.complete() == true)
				System.out.println("You Win!");
			if(board.complete() == false)
				System.out.println("You Lose!");
			
			System.out.println("Play again?(Yes/No)");
			again = input.next();
		
		}while(again == "Yes");

	}

}
