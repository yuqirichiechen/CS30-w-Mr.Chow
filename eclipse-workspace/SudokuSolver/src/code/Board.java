package code;

import java.io.File;
import java.util.Scanner;

public class Board{
	
	/*The Sudoku Board is made of 9x9 cells for a total of 81 cells.
	 * In this program we will be representing the Board using a 2D Array of cells.
	 * 
	 */

	Cell[][] board = new Cell[9][9];
	
	//The variable "level" records the level of the puzzle being solved.
	private String level = "";

	
	///TODO: CONSTRUCTOR
	//This must initialize every cell on the board with a generic cell.  It must also assign all of the boxIDs to the cells
	public Board()
	{
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
			{
				board[x][y] = new Cell();
				board[x][y].setBoxID( 3*(x/3) + (y)/3+1);
			}
	}
	

	
	///TODO: loadPuzzle
	/*This method will take a single String as a parameter.  The String must be either "easy", "medium" or "hard"
	 * If it is none of these, the method will set the String to "easy".  The method will set each of the 9x9 grid
	 * of cells by accessing either "easyPuzzle.txt", "mediumPuzzle.txt" or "hardPuzzle.txt" and setting the Cell.number to 
	 * the number given in the file.  
	 * 
	 * This must also set the "level" variable
	 * TIP: Remember that setting a cell's number affects the other cells on the board.
	 */
	public void loadPuzzle(String level) throws Exception
	{
		this.level = level;
		String fileName = "easyPuzzle.txt";
		if(level.contentEquals("medium"))
			fileName = "mediumPuzzle.txt";
		else if(level.contentEquals("hard"))
			fileName = "hardPuzzle.txt";
		
		Scanner input = new Scanner (new File(fileName));
		
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
			{
				int number = input.nextInt();
				if(number != 0)
					solve(x, y, number);
			}
						
		input.close();
		
	}
	
	///TODO: isSolved
	/*This method scans the board and returns TRUE if every cell has been solved.  Otherwise it returns FALSE
	 * 
	 */
	public boolean isSolved()
	{
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].getNumber() == 0)
					return false;
			}
		}
		return true;
	}


	///TODO: DISPLAY
	/*This method displays the board neatly to the screen.  It must have dividing lines to show where the box boundaries are
	 * as well as lines indicating the outer border of the puzzle
	 */
	public void display()
	{
		System.out.println("-------------------------");
		for(int x = 0; x < 9; x++) {
			if(x == 3 || x == 6)
				System.out.println("-------------------------");
			for(int y = 0; y < 9; y++) {
				if(y == 0 || y == 3 || y == 6)
					System.out.print("| ");
				System.out.print(board[x][y].getNumber() + " ");
				if(y == 8)
					System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("-------------------------");

	}
	
	///TODO: solve
	/*This method solves a single cell at x,y for number.  It also must adjust the potentials of the remaining cells in the same row,
	 * column, and box.
	 */
	public void solve(int x, int y, int number)
	{
		board[x][y].setNumber(number);
		for(int i = 0; i <9; i++) {
			if(i != x)
				board[i][y].cantBe(number);
		}
		
		for(int j = 0; j < 9; j++) {
			if(j != y)
				board[x][j].cantBe(number);
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i == x && j == y)
					continue;
				else if(board[i][j].getBoxID() == board[x][y].getBoxID())
					board[i][j].cantBe(number);
			}
		}
	}
	
	//logicCycles() continuously cycles through the different logic algorithms until no more changes are being made.
	public void logicCycles()throws Exception
	{
		
		//while(isSolved() == false)
		{
			int changesMade = 0;
			do
			{
				changesMade = 0;
				changesMade += logic1();
				changesMade += logic2();
				changesMade += logic3();
				changesMade += logic4();
				//if(errorFound())
					//break;
			}while(changesMade != 0);
	
		}			
		
	}
	
	
	///TODO: logic1
	/*This method searches each row of the puzzle and looks for cells that only have one potential.  If it finds a cell like this, it solves the cell 
	 * for that number. This also tracks the number of cells that it solved as it traversed the board and returns that number.
	 */
	public int logic1()
	{
		int changesMade = 0;
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {				
				if(board[x][y].numberOfPotentials() == 1 && board[x][y].getNumber() == 0)
				{
					solve(x,y,board[x][y].getFirstPotential());
					changesMade++;
				}
			}
		}
		System.out.println(changesMade);

		return changesMade;
					
	}
	
	///TODO: logic2
	/*This method searches each row for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
	 * is not already solved, it solves the cell.  It then does the same thing for the columns.This also tracks the number of cells that 
	 * it solved as it traversed the board and returns that number.
	 */
	
	public int logic2()
	{
		int changesMade = 0;
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].numberOfPotentials() > 1 && board[x][y].getNumber() == 0)
				{
					for(int i = 0; i < 10; i++) {
						boolean only = true;
						if(board[x][y].canBe(i) == true)
						{
							for(int a = 0; a < 9; a++)
							{
								if(board[a][y].canBe(i) == true && a != x)
									only = false;
							}
							if(only == true && board[x][y].getNumber() == 0)
							{
								solve(x,y,i);
								changesMade++;
							}
						}
						
					}
				}
			}
		}
		
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].numberOfPotentials() > 1 && board[x][y].getNumber() == 0)
				{
					for(int i = 0; i < 10; i++) {
						boolean only = true;
						if(board[x][y].canBe(i) == true)
						{
							for(int a = 0; a < 9; a++)
							{
								if(board[x][a].canBe(i) == true && a != y)
									only = false;
							}
							if(only == true && board[x][y].getNumber() == 0)
							{
								solve(x,y,i);
								changesMade++;
							}
						}
					}
				}
			}
		}
		System.out.println(changesMade);

		return changesMade;
	}
	
	///TODO: logic3
	/*This method searches each box for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
	 * is not already solved, it solves the cell. This also tracks the number of cells that it solved as it traversed the board and returns that number.
	 */
	public int logic3()
	{
	
		int changesMade = 0;
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].numberOfPotentials() > 1 && board[x][y].getNumber() == 0)
				{
					for(int i = 0; i < 10; i++) {
						boolean only = true;
						if(board[x][y].canBe(i) == true)
						{
							for(int a = 0; a < 9; a++)
							{
								for(int b = 0; b < 9; b++)
								{
									if(board[a][b].getBoxID() == board[x][y].getBoxID() && board[a][b].canBe(i) == true && board[a][b] != board[x][y])
										only = false;
								}
							}
							if(only == true && board[x][y].getNumber() == 0)
							{
								solve(x,y,i);
								changesMade++;
							}
						}
					}
				}
			}
		}
		
		System.out.println(changesMade);
		
		return changesMade;
	}
	
	
	///TODO: logic4
		/*This method searches each row for the following conditions:
		 * 1. There are two unsolved cells that only have two potential numbers that they can be
		 * 2. These two cells have the same two potentials (They can't be anything else)
		 * 
		 * Once this occurs, all of the other cells in the row cannot have these two potentials.  Write an algorithm to set these two potentials to be false
		 * for all other cells in the row.
		 * 
		 * Repeat this process for columns and rows.
		 * 
		 * This also tracks the number of cells that it solved as it traversed the board and returns that number.
		 */
	public int logic4()
	{
		int changesMade = 0;
		
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].numberOfPotentials() == 2) {
					for(int z = 0; z < 9; z++) {
						if(board[x][z].numberOfPotentials()==2) {
							if(board[x][y].getFirstPotential() == board[x][z].getFirstPotential() && board[x][y].getSecondPotential() == board[x][z].getSecondPotential()) {
								for(int a = 0; a < 9; a++) {
									if(a == y || a ==z)
										continue;
									if(board[x][a].canBe(board[x][y].getFirstPotential())) {
										board[x][a].cantBe(board[x][y].getFirstPotential());
										changesMade++;
									}
									if(board[x][a].canBe(board[x][y].getSecondPotential())) {
										board[x][a].cantBe(board[x][y].getSecondPotential());
										changesMade++;
									}
								}
							}
						}
					}
				}
			}
		}
		
		/*
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].numberOfPotentials() == 2) {
					for(int z = 0; z < 9; z++) {
						if(board[z][y].numberOfPotentials()==2) {
							if(board[x][y].getFirstPotential() == board[z][y].getFirstPotential() && board[x][y].getSecondPotential() == board[z][y].getSecondPotential()) {
								for(int a = 0; a < 9; a++) {
									if(a == x || a ==z)
										continue;
									if(board[a][y].canBe(board[x][y].getFirstPotential())) {
										board[a][y].cantBe(board[x][y].getFirstPotential());
										changesMade++;
									}
									if(board[a][y].canBe(board[x][y].getSecondPotential())) {
										board[a][y].cantBe(board[x][y].getSecondPotential());
										changesMade++;
									}
								}
							}
						}
					}
				}
			}
		}
		*/
		System.out.println(changesMade);
		
		return changesMade;
	}
	
	
	///TODO: errorFound
	/*This method scans the board to see if any logical errors have been made.  It can detect this by looking for a cell that no longer has the potential to be 
	 * any number.
	 */
	public boolean errorFound()
	{
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				if(board[x][y].getNumber() == 0 && board[x][y].numberOfPotentials()==0)
					return true;
			}
		}
		
		return false;
	}
	
	
	
}
