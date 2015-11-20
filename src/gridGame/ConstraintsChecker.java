package gridGame;

import java.util.*;
import gridGame.constraints.*;

public class ConstraintsChecker {

	private ConstraintsCheckerListener mListener = null;
	private List<Constraint> mConstraintList = null;
	
	public ConstraintsChecker(ConstraintsCheckerListener listener) {
		mListener = listener;
		mConstraintList = new ArrayList<Constraint>();

		mConstraintList.add(new OffGridConstraint(9, 0));
		mConstraintList.add(new PositionAlreadyOccupiedConstraint());
		mConstraintList.add(new PatternConstraint());
	}

	public void checkConstraints(Grid grid, int row, int column) {
		if (allConstraintsSatisfied(grid, row, column)) {
			mListener.onAllConstraintsSatisfied();
		}
		else {
			mListener.onConstraintViolated();
		}
	}

	private boolean allConstraintsSatisfied(Grid grid, int row, int column) {

		//Check each constraint to see if the chosen row and column violates it.
		for (Constraint constraint : mConstraintList) {
			if (!constraint.constraintSatisfied(grid, row, column)) {
				//reset the constraint for the next time
				constraint.reset();
				return false;
			}
				
		}

		return true;
	}

	public static interface ConstraintsCheckerListener {
		void onAllConstraintsSatisfied();
		void onConstraintViolated();
	}

}