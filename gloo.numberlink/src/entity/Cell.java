package entity;

public class Cell {
	
	private Grid grid;
	private int line;
	private int column;
	private End end = null;
	private Path path = null;

	public Cell(Grid grid, int line, int column) {
		this.grid = grid;
		this.line = line;
		this.column = column;
	}
	
	public Cell(Grid grid, int line, int column, End end) {
		this.grid = grid;
		this.line = line;
		this.column = column;
		this.end = end;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
	public Path getPath() {
		return path;
	}
	
	/*
	 * Creates and returns a new path and adds the current cell to it.
	 */
	public Path createNewPath() {
		Path newPath = end.createNewPath();
		newPath.addCell(this);
		this.path = newPath;
		return newPath;
	}
	
	/*
	 * Returns the neighbor cell in a given direction. Throws an exception if it does not exist in the grid.
	 * @dir The direction in which we look for the neighbor
	 */
	public Cell getNeighbor(Direction dir) {
		return grid.getNeighbor(this, dir);
	}
	
	/*
	 * Returns a boolean indicating whether or not the current cell can accept path p
	 * @p The path we want to put our cell in
	 */
	public boolean accept(Path p) {
		if (end == null){
			return (path == null);
		} else {
			Tag tag = p.getTag();
			return end.sameTag(tag);
		}
	}
	
	/*
	 * Returns a boolean indicating if the current cell is a path.
	 */
	public boolean hasPath() {
		return !(path == null);
	}
	
	public void setEnd(End end) {
		this.end = end;
	}
	
	public void setPath(Path path) {
		this.path = path;
	}
	
	public void CellString() {
		if (path == null) {
			System.out.println("null");
		} else {
			path.PathString();
		}
	}
}