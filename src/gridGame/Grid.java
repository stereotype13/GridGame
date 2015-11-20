package gridGame;

import java.util.*;

public class Grid {

	private GridListener mParentGame = null;
	private List<ArrayList<Integer>> mGrid;
	private int mSize = 10;
	private boolean mConstraintsSatisfied = false;

	public Grid(int size, Game parent) {
		mParentGame = parent;
		mSize = size;
		mGrid = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < mSize; ++i) {
			mGrid.add(new ArrayList<Integer>());
			for (int j = 0; j < mSize; ++j) {
				mGrid.get(i).add(0);
			}
		}
	}

	public int get(int row, int column) {
		return mGrid.get(row).get(column);
	}

	public void set(int row, int column, int theNumber) {
		mParentGame.onSetAttempt(row, column);

		if (mConstraintsSatisfied) {
			mGrid.get(row).set(column, theNumber);
			mParentGame.onSet(row, column);
			
		}

		//reset this flag back to default value of false. Assume constraints are not satisfied until proven otherwise.
		mConstraintsSatisfied = false;
		
	}

	public String toString() {
		String tempStringOuter = "";
		for (int i = 0; i < mSize; ++i) {
			String tempStringInner = "";
			for (int j = 0; j < mSize; ++j) {
				tempStringInner += String.format("%1$-"+ 3 + "s", mGrid.get(i).get(j));
				
			}
			tempStringOuter += (tempStringInner + "\n");
		}
		return tempStringOuter;
	}

	public static interface GridListener {
		void onSetAttempt(int row, int column);
		void onSet(int row, int column);
	}

	public void setConstraintsSatisfied(boolean satisfied) {
		mConstraintsSatisfied = satisfied;
	}

	public boolean getConstraintsSatisfied(boolean satisfied) {
		return mConstraintsSatisfied;
	}
}