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
	
	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
	public Path createNewPath() {
		Path newPath = end.createNewPath();
		newPath.addCell(this);
		this.path = newPath;
		return newPath;
	}
	
	public Cell getNeighbor(Direction dir) {
		grid.getNeighbor(this, dir);
	}
	
	public boolean accept(Path p) {
		return (path == null)&&(end == null);
	}
	
	public boolean hasPath() {
		return (path != null)
	}
}