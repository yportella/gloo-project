package entity;

public class Grid {
	
	private int nbLines;
	private int nbColumns;
	private int nbTags;
	private Cell[][] cells;
	

	public Grid(int nbLines, int nbColumns, int nbTags) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.nbTags = nbTags;
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
	
	/*
	 * Returns the neighbor cell in a given direction. Throws an exception if it does not exist in the grid.
	 * @cell The cell around which we look for the neighbor
	 * @dir The direction in which we look for the neighbor
	 */
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
			Grid grid = cell.getGrid();
			return grid.cells[line][column];
			}
		catch (Exception e) {
			System.out.println("Case en dehors de la grille");
			return null;
		}
	}
	
	/*
	 * Returns a boolean indicating whether or not the game is finished.
	 */
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
	
	public int getNbLines() {
		return nbLines;
	}

    public int getNbColumns() {
    	return nbColumns;
    }
    
    public int getNbTags() {
    	return nbTags;
    }
    
    public Path getCellPath(int indLine, int indColumn) {
    	return cells[indLine][indColumn].getPath();
    }
    
    public void setCells(Cell[][] cells) {
    	this.cells = cells;
    }
    
    public Cell[][] getCells() {
    	return cells;
    }
    
    public void GridString(){
    	for (int i = 0; i < nbLines; i++) {
			for (int j = 0; j < nbColumns; j++) {
				cells[i][j].CellString();				
			}
		}
    }
    

}
