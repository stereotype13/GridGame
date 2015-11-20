package gridGame.constraints;

import gridGame.Grid;

public interface Constraint {
	boolean constraintSatisfied(Grid grid, int row, int column);
	void reset();
}