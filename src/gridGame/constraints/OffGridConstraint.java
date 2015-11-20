package gridGame.constraints;

import gridGame.Grid;

public class OffGridConstraint implements Constraint {

	private boolean mConstaintSatisfied = true;
	private int mUpperBound = 9;
	private int mLowerBound = 0;

	public OffGridConstraint(int upperBound, int lowerBound) {
		mUpperBound = upperBound;
		mLowerBound = lowerBound;
	}

	public boolean constraintSatisfied(Grid grid, int row, int column) {
		if (row < mLowerBound || row > mUpperBound)
			mConstaintSatisfied = false;

		if (column < mLowerBound || column > mUpperBound)
			mConstaintSatisfied = false;

		return mConstaintSatisfied;
	}

	public void reset() {
		mConstaintSatisfied = true;
	}
}