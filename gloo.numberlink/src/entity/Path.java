package entity;

import control.Direction;

public class Path {
	
	private Cell[] cells;
	private int indNext = 0;
	private final static int TAILLE_MAX = 30;
	private Tag tag;

	public Path(Tag tag) {
		cells = new Cell[TAILLE_MAX];
		this.tag = tag;
	}
	
	/*
	 * Adds a new cell to the path.
	 * @cell The cell we want to add.
	 */
	public void addCell(Cell cell) {
		cells[indNext] = cell;
		cells[indNext].setPath(this);
		indNext++;
	}
	
	/*
	 * Returns a boolean indicating whether or not the path can advance in direction dir. If it is the case, it
	 * also adds the corresponding cell.
	 * @dir The direction we want to move in.
	 */
	public boolean advance(Direction dir) {
		Cell last = this.getLastCell();
		Cell neighbor = last.getNeighbor(dir);
		if (neighbor == null) {
			return false;
		}
		boolean res = neighbor.accept(this);
		if (res) {
			this.addCell(neighbor);
		}
		return res;
	}
	
	public Cell getLastCell() {
		return this.cells[indNext-1];
	}
	
	public Tag getTag() {
		return tag;
	}
	
	public int getTagId() {
		return tag.getTagId();
	}
	
}