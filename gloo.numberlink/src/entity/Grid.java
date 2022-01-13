package entity;

public class Grid {
	
	private int nbLines;
	private int nbColumns;
	private Cell[] cells;
	

	public Grid(int nbLines, int nbColumns) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.cells = new Cell[nbLines * nbColumns];
	}
	
	/*
	 * Returns a new path by calling the method of the cell from which we want to create this path
	 * @indLine  The index of the cell's line
	 * @indColumn  The index of the cell's column
	 */
	public Path createNewPath(int indLine, int indColumn) {
		return cells[indLine * nbColumns + indColumn].createNewPath();
	}

}
