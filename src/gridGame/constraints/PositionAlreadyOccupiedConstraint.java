package gridGame.constraints;

import gridGame.Grid;

public class PositionAlreadyOccupiedConstraint implements Constraint {

	private boolean mConstaintSatisfied = true;
	

	public PositionAlreadyOccupiedConstraint() {
		
	}

	public boolean constraintSatisfied(Grid grid, int row, int column) {
		if (grid.get(row, column) != 0)
			mConstaintSatisfied = false;

		return mConstaintSatisfied;
	}

	public void reset() {
		mConstaintSatisfied = true;
	}
}