package entity;

public class Path {
	
	private Cell[] cells;
	private int indNext = 0;
	private final static int TAILLE_MAX = 30;
	private Tag tag;

	public Path(Tag tag) {
		cells = new Cell[TAILLE_MAX];
		this.tag = tag;
	}
	
	public void addCell(Cell cell) {
		cells[indNext] = cell;
		indNext++;
	}
	
	public boolean advance(Direction dir) {
		Cell last = this.getLastCell();
		Cell neighbor = last.getNeighbor(dir);
		boolean res = neighbor.accept(this);
		if (res) {
			this.addCell(neighbor);
		}
		return res;
	}
	
	private Cell getLastCell() {
		return this.cells[indNext-1];
	}
	
	public Tag getTag() {
		return tag;
	}

}