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
		int line = 0;
		int column = 0;
		switch(dir) {
		case UP : 
			line = cell.getLine()-1;
			column = cell.getColumn();
			break;
		case DOWN : 
			line = cell.getLine()+1;
			column = cell.getColumn();
			break;
		case LEFT :
			line = cell.getLine();
			column = cell.getColumn()-1;
			break;
		case RIGHT :
			line = cell.getLine();
			column = cell.getColumn()+1;
		}
		try {
			return new Cell(cell.getGrid(), line, column);
			}
		catch (Exception e) {
			System.out.println("Case en dehors de la grille");
		}
	}
	
	public boolean isFinished() {
		for (int i = 0; i < nbLines; i++) {
			for (int j = 0; j < nbColumns; j++) {
				if (!(cells[i][j].hasPath())){
					return false;
				}
				
			}
		}
		return true;
	}

}
