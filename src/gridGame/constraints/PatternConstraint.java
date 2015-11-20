package gridGame.constraints;

import gridGame.Grid;

public class PatternConstraint implements Constraint {

	private boolean mConstaintSatisfied = true;
	private int mLastRowChosen = -1;
	private int mLastColumnChosen = -1;
	
	public PatternConstraint() {

	}

	public boolean constraintSatisfied(Grid grid, int row, int column) {
		
		if (mLastRowChosen == -1) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		if (row + 2 == mLastRowChosen && column + 2 == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}
			

		if (row + 2 == mLastRowChosen && column - 2 == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		if (row - 2 == mLastRowChosen && column - 2 == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		if (row - 2 == mLastRowChosen && column + 2 == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		/////
		if (row - 3 == mLastRowChosen && column == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		if (row + 3 == mLastRowChosen && column == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		if (row == mLastRowChosen && column + 3 == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}

		if (row == mLastRowChosen && column - 3 == mLastColumnChosen) {
			mLastRowChosen = row;
			mLastColumnChosen = column;
			return true;
		}
		

		return (mConstaintSatisfied = false);
	}

	public void reset() {
		mConstaintSatisfied = true;
	}
}