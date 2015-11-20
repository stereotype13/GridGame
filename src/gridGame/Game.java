package gridGame;

import java.util.Scanner;

public class Game implements Grid.GridListener, ConstraintsChecker.ConstraintsCheckerListener {
	private Grid mGrid = null;
	private Player mPlayer = null;
	private int mCurrentNumber = 1;
	private ConstraintsChecker mConstraintsChecker = null;

	public Game() {
		mGrid = new Grid(10, this);
		mPlayer = new Player();
		mConstraintsChecker = new ConstraintsChecker(this);

		System.out.println(mGrid.toString());
	}

	public void run() {
		Scanner reader = new Scanner(System.in); 
		while (true) {
			System.out.println("Choose row: ");
			int row = reader.nextInt();

			System.out.println("Choose column: ");
			int column = reader.nextInt();

			mPlayer.place(mGrid, row, column, mCurrentNumber);
			

			System.out.println(mGrid.toString());
		}
		
		
	}

	//Alerted by Grid
	public void onSetAttempt(int row, int column) {
		mConstraintsChecker.checkConstraints(mGrid, row, column);
	}

	//Alerted by Grid
	public void onSet(int row, int column) {
		++mCurrentNumber;
	}

	//Alerted by ConstraintsChecker
	public void onAllConstraintsSatisfied() {
		mGrid.setConstraintsSatisfied(true);
	}

	//Alerted by ConstraintsChecker
	public void onConstraintViolated() {
		System.out.println("Constraint violated.");
	}

	
}