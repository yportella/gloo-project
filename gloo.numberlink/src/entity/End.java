package entity;

public class End {
	
	private Tag tag;
	private Cell cell;
	
	public Path createNewPath() {
		return tag.createNewPath();
	}
}
