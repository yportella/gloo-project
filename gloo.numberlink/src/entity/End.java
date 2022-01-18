package entity;

public class End {
	
	private Tag tag;
	private Cell cell;
	
	public End(Tag tag, Cell cell) {
		this.tag = tag;
		this.cell = cell;
	}
	
	public Path createNewPath() {
		return tag.createNewPath();
	}
	
	public boolean sameTag(Tag t) {
		return tag.equals(t);
	}

}
