package code;

import java.io.*;
import java.util.Scanner;

public class gomoku {
	
        public static int boardSize = 21; //define the size of the board
        
    public static  char[][] board;
    
    public static void createBoard()
    {
    	char horizontalCount = 96;
    	char verticalCount = 'a';
    	
        board = new char[boardSize][boardSize];
        
        for (int i = 0 ; i < boardSize ; i++)
        {
            for ( int j = 0 ; j < boardSize ; j++)
            {
	            if(i == 0)
	            {
	            	board[i][j] = horizontalCount;
	            	horizontalCount++;
	            }
            	
	            else if(j == 0)
            	{
	            	board[i][j] = verticalCount;
	            	verticalCount++;
            	}
            	
            	else
            	{
            		board[i][j] = '+';
            	}
            	
            }
        }
        
        board[0][0] = ' ';
        
    }
    
    public static void printBoard()
    {
    	
        for (int i = 0 ; i < boardSize ; i++)
        {
            for ( int j = 0 ; j < boardSize ; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
        
    }
    
    public static void firstPlayerDecision(int x, int y)
    {
    	board[x][y] = '⬤';
    }   
    
    public static void secondPlayerDecision(int x, int y)
    {
    	board[x][y] = '〇';
    }	
    
    public static void main(String[] args) throws Exception
    {
    	
    	Scanner sc = new Scanner(System.in);
    	int menuChoice = 0;
    	boolean playerOneWin = false;
    	boolean playerTwoWin = false;
    	createBoard();
    	
        System.out.println("=======================================");
        System.out.println("		Main Menu");
        System.out.println("=======================================");
        System.out.println();
        System.out.println("Please choose from the following options");
        System.out.println();
        System.out.println("1. Start the two player gomoku game");
        System.out.println("2. Check game rules");
        System.out.println("3. Quit the game");
        System.out.println();
        System.out.print("Your choice: ");
        menuChoice = sc.nextInt();
        System.out.println();

        if (menuChoice == 1)
        {
        	do
        	{
        		printBoard();
                System.out.println("First player please make your decision");
                System.out.print("Horizontal: ");
                String firstPlayerHorizontal = sc.next();
                System.out.print("Vertical: ");
                String firstPlayerVertical= sc.next();
                //firstCheckWin();
                if(playerOneWin == true)
                {
                    System.out.println("First player won!");
                	break;
                }
                
                System.out.println("Second player please make your decision");
                System.out.print("Horizontal: ");
                String secondPlayerHorizontal = sc.next();
                System.out.print("Vertical: ");
                String secondPlayerVertical= sc.next();
               // secondCheckWin();
                if(playerTwoWin == true)
                {
                    System.out.print("Second player won!");
                	break;
                }

        	}while(playerOneWin == false && playerTwoWin == false);
        	
        }

        else if (menuChoice == 2)
    	{
    		
    	}
    
        else if (menuChoice == 3)
        	System.exit(0);
    	
        }
    }

