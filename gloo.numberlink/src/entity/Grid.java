package entity;

public class Grid {
	
	private int nbLines;
	private int nbColumns;
	private Cell[][] cells;
	

	public Grid(int nbLines, int nbColumns) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.cells = new Cell[nbLines][nbColumns];
	}
	
	/*
	 * Returns a new path by calling the method of the cell from which we want to create this path
	 * @indLine  The index of the cell's line
	 * @indColumn  The index of the cell's column
	 */
	public Path createNewPath(int indLine, int indColumn) {
		return cells[indLine][indColumn].createNewPath();
	}
	
	public Cell getNeighbor(Cell cell, Direction dir) {
		int line;
		int column;
		switch(dir) {
		case UP : 
			line = cell.line-1;
			column = cell.column;
			break;
		case DOWN : 
			line = cell.line+1;
			column = cell.column;
			break;
		case LEFT :
			line = cell.line;
			column = cell.column-1;
			break;
		case RIGHT :
			line = cell.line;
			column = cell.column+1;
		}
		try {
			return new Cell(cell.grid, line, column);
			}
		catch (Exception e) {
			System.out.println("Case en dehors de la grille")
		}
	}
	
	public boolean isFinished() {
		for (i = 0; i < nbLines; i++) {
			for (j = 0; j < nbColumns; j++) {
				if !(cells[i][j].hasPath()){
					return false;
				}
				
			}
		}
		return true
	}

}
