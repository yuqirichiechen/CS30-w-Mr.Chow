package SudokuSolver01;

import java.io.File;
import java.util.Scanner;

import SudokuSolver.Cell;

public class Board {
    
    public static Cell [][] board  = new Cell[9][9];
    public static Guess[] boardStates = new Guess[81];
    public static int guessCount = 0; 
    
    public static void solve(int x, int y, int number){
        board[x][y].setNumber(number);
        int boxID = board[x][y].getBoxID();
        
        for (int i = 0; i< 9; i++){
            board[i][y].cantBe(number);
            board[x][i].cantBe(number);
        }
        
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j].getBoxID() == boxID)
                    board[i][j].cantBe(number);
        
        board[x][y].setPossible(number);
    }
    
    //loads the puzzle from the file with the given file name.
    public static void loadPuzzle(String filename) throws Exception{
        Scanner input = new Scanner( new File(filename) );
        
        for(int x = 0; x < 9; x++)
            for(int y = 0; y< 9; y++){
                int number = input.nextInt();
                if(number != 0)
                    solve(x,y,number);
            }
    }
    
    /*We need a method that will display the board so we can verify our programming as we go*/
    public static void display() {
        System.out.println("-------------------------");
        for(int x = 0; x < 9; x++) {
            System.out.print("| ");
            for(int y = 0; y < 9; y++) {
                System.out.print(board[x][y].getNumber() + " ");
                if((y+1)%3 == 0)
                    System.out.print("| ");
            }
            System.out.println();
            if((x+1)%3 == 0)
                System.out.println("-------------------------");
        }
        System.out.println();
    }
    
    public static int logic1(){
        int changesMade = 0;
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                if(board[x][y].howManyPossible() == 1 && board[x][y].getNumber() == 0){
                    solve(x,y,board[x][y].getFirstPossible());
                    changesMade++;
                }    
            }
        }
        return changesMade;
    }
    
    public static int logic2r(){
        //searching row
        int changesMade = 0;
        
        for(int number = 1; number < 10; number++)
            for(int x = 0; x < 9; x++){
                
                boolean numberAlreadySolved = false;
                int count = 0;
                
                //looking to see if the number in this row is already solved
                for(int y = 0; y < 9; y++)
                    if(board[x][y].getNumber() == number)
                        numberAlreadySolved = true;
                
                if(!numberAlreadySolved){
                    //count how many cells can be that number
                    for(int y = 0; y < 9; y++)
                        if(board[x][y].canBe(number))
                            count++;
                    
                    if(count == 1)
                        for(int y = 0; y < 9; y++)
                            if(board[x][y].canBe(number)){
                                solve(x,y,number);
                                changesMade++;
                            }
                }
            }    
        return changesMade;
    }
    
    public static int logic2c(){
        //searching columns
        int changesMade = 0;

        for(int number = 1; number < 10; number++)
            for(int y = 0; y < 9; y++){
                
                boolean numberAlreadySolved = false;
                int count = 0;
                
                //looking to see if the number in this row is already solved
                for(int x = 0; x < 9; x++)
                    if(board[x][y].getNumber() == number)
                        numberAlreadySolved = true;
                
                if(!numberAlreadySolved){
                    //count how many cells can be that number
                    for(int x = 0; x < 9; x++)
                        if(board[x][y].canBe(number))
                            count++;
                    
                    if(count == 1)
                        for(int x = 0; x < 9; x++)
                            if(board[x][y].canBe(number)){
                                solve(x,y,number);
                                changesMade++;
                            }
                }
            }    
        return changesMade;
    }
    
    public static int logic3(){
        //searching boxes
        int changesMade = 0;

        for(int number = 1; number < 10; number++){
            
            for(int box = 1; box < 10; box++){
                
                boolean numberAlreadySolved = false;
                int count = 0;
                
                //looking to see if the number in this box is already solved
                for(int x = 0; x < 9; x++)
                    for(int y = 0; y < 9; y++)
                        if(board[x][y].getBoxID() == box && board[x][y].getNumber() == number)
                            numberAlreadySolved = true;
                
                if(!numberAlreadySolved){
                    //count how many cells can be that number
                    for(int x = 0; x < 9; x++)
                        for(int y = 0; y < 9; y++)
                            if(board[x][y].getBoxID() == box && board[x][y].canBe(number))
                                count++;
                    
                    if(count == 1)
                        for(int x = 0; x < 9; x++)
                            for(int y = 0; y < 9; y++)
                                if(board[x][y].getBoxID() == box && board[x][y].canBe(number)){
                                    solve(x,y,number);
                                    changesMade++;
                                }
                }
            }
        }
        return changesMade;
    }
    
    
    public static int logic4r(){
        int changesMade = 0;
        
        for(int x = 0; x < 9; x++){
            //look for a cell with two possibilities
            for(int y = 0; y < 9; y++){
                if(board[x][y].howManyPossible() == 2){
                    //found a two possibility cell
                    int j = y+1;
                    while(j < 9){
                        //check the rest of the row for another 2 possibility cell
                        if(board[x][j].howManyPossible() == 2){
                            //found another one - check if they're the same 2 possibilities
                            if(board[x][y].getFirstPossible() == board[x][j].getFirstPossible()){
                                if(board[x][y].getSecondPossible() == board[x][j].getSecondPossible()){
                                    //found a match    
                                    for(int b = 0; b < 9; b++){
                                        if(b == y || b == j)//skip the two cells
                                            continue;
                                        else{
                                            if(board[x][b].canBe(board[x][y].getFirstPossible())){
                                                board[x][b].cantBe(board[x][y].getFirstPossible());
                                                changesMade++;
                                            }
                                            if(board[x][b].canBe(board[x][y].getSecondPossible())){
                                                board[x][b].cantBe(board[x][y].getSecondPossible());
                                                changesMade++;
                                            }
                                            
                                        }
                                            
                                    }
                                }
                            }
                        }
                        j++;
                    }            
                }
            }        
        }
        return changesMade;
    }
    public static int logic4c(){
        int changesMade = 0;
        
        for(int y = 0; y < 9; y++){
            //look for a cell with two possibilities
            for(int x = 0; x < 9; x++){
                if(board[x][y].howManyPossible() == 2){
                    //found a two possibility cell
                    int i = x+1;
                    while(i < 9){
                        //check the rest of the row for another 2 possibility cell
                        if(board[i][y].howManyPossible() == 2){
                            //found another one - check if they're the same 2 possibilities
                            if(board[x][y].getFirstPossible() == board[i][y].getFirstPossible()){
                                if(board[x][y].getSecondPossible() == board[i][y].getSecondPossible()){
                                    //found a match
                                    //TEST CODE
                                    /*  display();
                                     
                                    System.out.println("Situation Found for Cells:");
                                    System.out.println(x + "," + y +" and " + i + "," + y);
                                    System.out.println("Removing possibilities for:");
                                    System.out.println(board[x][y].getFirstPossible() + " & " + board[x][y].getSecondPossible() );
                                    */
                                    
                                    for(int a = 0; a < 9; a++){
                                        if(a == x || a == i)//skip the two cells
                                            continue;
                                        else{
                                            if(board[a][y].canBe(board[x][y].getFirstPossible())){
                                                board[a][y].cantBe(board[x][y].getFirstPossible());
                                                changesMade++;
                                            }
                                            if(board[a][y].canBe(board[x][y].getSecondPossible())){
                                                board[a][y].cantBe(board[x][y].getSecondPossible());
                                                changesMade++;
                                            }
                                            
                                        }
                                            
                                    }
                                }
                            }
                        }
                        i++;
                    }            
                }
            }        
        }
        return changesMade;
    }
    
    public static int logic4b(){
        int changesMade = 0;
        
        //first, looking for a cell with two potentials
        for(int x = 0; x < 9; x++)
            for(int y = 0; y < 9; y++)
                if(board[x][y].howManyPossible() == 2){
                    //found a 2-potential cell - looking for another in the same box
                    
                    for(int i = 0; i < 9; i++)
                        for(int j = 0; j < 9; j++)
                        {
                            if(i==x && j==y)
                                continue;
                            if(board[i][j].howManyPossible() == 2 && board[i][j].getBoxID() == board[x][y].getBoxID() && board[i][j].getFirstPossible() == board[x][y].getFirstPossible() && board[i][j].getSecondPossible() == board[x][y].getSecondPossible()){
                                //found it!
                                for(int a = 0; a < 9; a++)
                                    for(int b = 0; b < 9; b++)
                                        if(board[a][b].getBoxID() == board[x][y].getBoxID())
                                            if( !( (a==x && b==y) || (a==i && b==j) ))
                                            {
                                                //TEST CODE
                                                /*
                                                 display();
                                                 
                                                System.out.println("Situation Found for Cells:");
                                                System.out.println(x + "," + y +" and " + i + "," + j);
                                                System.out.println("Removing possibilities for:");
                                                System.out.println(board[x][y].getFirstPossible() + " & " + board[x][y].getSecondPossible() );
                                                test();
                                                */
                                                
                                                if(board[a][b].canBe(board[x][y].getFirstPossible())){
                                                    board[a][b].cantBe(board[x][y].getFirstPossible());
                                                    changesMade++;
                                                }
                                                if(board[a][b].canBe(board[x][y].getSecondPossible())){
                                                    board[a][b].cantBe(board[x][y].getSecondPossible());
                                                    changesMade++;
                                                }
                                                
                                            }
                                
                            }
                                
                                
                        }
                        
                }
        
        
        
        return changesMade;
    }
    
    public static boolean hasSamePossibles(Cell a, Cell b)
    {
        for(int n = 1; n <10; n++)
            if(a.canBe(n) != b.canBe(n))
                return false;
        return true;
    }
    
    //This is for logic 5 but only works with rows - a modified algorithm would be needed for columns and boxes
    //but would follow the same logic.
    public static int logic4rnew()
    {
        int changesMade = 0;
        for(int x = 0; x < 9; x++)
        {
            for(int y = 0; y < 9; y++)
            {
                int numberPossible = board[x][y].howManyPossible();
                int samePossibles = 1;
                for(int q = y+1; q < 9; q++)
                    if(hasSamePossibles(board[x][y], board[x][q]))
                        samePossibles++;
                
                if(samePossibles == numberPossible)//the situation exists
                {
                    for(int q = 0; q < 9; q++)
                        if(!hasSamePossibles(board[x][y], board[x][q]))
                        {
                            for(int n = 1; n < 10; n++)
                                if(board[x][q].canBe(n) && board[x][y].canBe(n)){
                                    board[x][q].cantBe(n);
                                    changesMade++;
                                }    
                        }
                }
            }
        }
        
        return changesMade;
    }
    
    
    


    //a useful utility for testing
    public static void test(){
        
        int x = 0;
        int y = 0;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        
        do{
            display();
            System.out.println("cell[" +x + "][" + y + "]");
            System.out.println("Number: " + board[x][y].getNumber());
            System.out.println("BoxID:" +board[x][y].getBoxID());
            board[x][y].showPossibles();
            
            choice = input.nextInt();
            if(choice == 2)
                x++;
            else if (choice == 8)
                x--;
            else if (choice == 4)
                y--;
            else if (choice == 6)
                y++;
            
        }while(choice != -1);
        

    }
    
    public static boolean isSolved(){
        for(int x = 0; x < 9; x++)
            for(int y = 0; y < 9; y++)
                if(board[x][y].getNumber() == 0)
                    return false;

        return true;
    }
    
    public static boolean contradictionFound(){
        for(int x = 0; x < 9; x++)
            for(int y = 0; y< 9; y++)
                if(board[x][y].howManyPossible() == 0)
                    return true;
        return false;
        
    }
    
    public static void revert()
    {
        for(int x = 0; x < 9; x++)
            for(int y = 0; y< 9; y++)
            {
                board[x][y] = new Cell();
                board[x][y].setBoxID( x/3*3 + y/3+1 );
                board[x][y].setNumber(boardStates[guessCount-1].getBoard()[x][y].getNumber());
                for(int q = 1; q < 10; q++)
                    if(boardStates[guessCount-1].getBoard()[x][y].canBe(q) == false)
                        board[x][y].cantBe(q);
                    else
                        board[x][y].setPossibleXTrue(q);
            }
        
        board[boardStates[guessCount-1].getGuessX()][boardStates[guessCount-1].getGuessY()].cantBe(boardStates[guessCount-1].getGuessNumber());    
        guessCount--;
    }
    
    public static void main(String[] args)throws Exception{

    //This sets up the objects in the board and sets the boxIDs
    for(int x = 0; x < 9; x++)
        for(int y = 0; y< 9; y++){
            board[x][y] = new Cell();
            board[x][y].setBoxID( x/3*3 + y/3+1 );
        }

    loadPuzzle("hard.txt");    
    display();
    
    //do
    {
        boolean reverted = false;
        int changesMade = 0;
        do{
            changesMade = 0;
            changesMade += logic1();
            changesMade += logic2r();
            changesMade += logic2c();
            changesMade += logic3();
            changesMade += logic4rnew();
            changesMade += logic4c();
            changesMade += logic4b();
        }while(changesMade != 0);
        
        //if there is a cell that has no possibilities, we must have made a wrong guess
        //and need to revert back
        if(contradictionFound()){
            revert();
            reverted = true;
        }
        //At this point, if the puzzle is not solved, we need to make a guess
        if(!reverted && !isSolved() && !contradictionFound())
        {
            //find the first unsolved cell;
            int unsolvedX = -1;
            int unsolvedY = -1;
            for(int x = 0; x < 9; x++)
            {
                for(int y = 0; y< 9; y++){
                    if(board[x][y].getNumber() == 0){
                        unsolvedX = x;
                        unsolvedY = y;
                        break;
                    }
                }
                if(unsolvedX != -1)
                    break;
            }
            
            
            //System.out.println("First unsolved cell at: " + unsolvedX + "," + unsolvedY);
            
            //The guess will be the first possible number of the unsolved cell
            int guess = board[unsolvedX][unsolvedY].getFirstPossible();
            
            //Now that I have the unsolved cell location and guess, I can save the board state
            boardStates[guessCount++] = new Guess(board,unsolvedX,unsolvedY,guess);
            

            //since the board state is saved, I can safely make a guess
            solve(unsolvedX, unsolvedY,guess);
            
        }
    }//while(!isSolved());
    
    display();    
    
    }
}