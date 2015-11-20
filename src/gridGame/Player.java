package gridGame;

public class Player {
	public Player() {}

	public void place(Grid grid, int row, int column, int number) {
		grid.set(row, column, number);
	}
}