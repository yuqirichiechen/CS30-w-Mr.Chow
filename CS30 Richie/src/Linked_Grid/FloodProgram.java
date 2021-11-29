package Linked_Grid;

import java.util.Scanner;

public class FloodProgram {

	
	public static void populate(Node temp, int x)
	{
		if(temp.getLeft()!=null && temp.getLeft().getData() == temp.getData())
			populateOnce1(temp.getLeft(), x);
		
		if(temp.getUp()!=null && temp.getUp().getData() == temp.getData())
			populateOnce2(temp.getUp(), x);
		
		if(temp.getRight()!=null && temp.getRight().getData() == temp.getData())
			populate(temp.getRight(), x);
		
		if(temp.getDown()!=null && temp.getDown().getData() == temp.getData())
			populate(temp.getDown(), x);
		
		temp.setData(x);
		
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
			LinkedGrid board = new LinkedGrid(20,20);
			int chance = 25;
			
			do
			{
				board.display();
				System.out.println("You have " + chance + "/25 chances left");
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
