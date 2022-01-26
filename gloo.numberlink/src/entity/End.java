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
	
	/*
	 * Checks if the current tag is equal to the argument.
	 * @t The tag we want to compare with the current one.
	 */
	public boolean sameTag(Tag t) {
		return tag.equals(t);
	}

	public Tag getTag() {
		return tag;
	}

	public Cell getCell() {
		return cell;
	}

}
