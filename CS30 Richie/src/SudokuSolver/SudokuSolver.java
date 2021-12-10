package SudokuSolver;

public class SudokuSolver {

	public static void main(String[] args)throws Exception {
		
		Board puzzle = new Board();
		puzzle.loadPuzzle("medium");
		puzzle.display();
		puzzle.logicCycles();
		System.out.println();
		puzzle.display();
		System.out.println(puzzle.errorFound());
		System.out.println(puzzle.isSolved());


	}

}
