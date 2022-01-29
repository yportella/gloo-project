package entity;

public class Tag {
	
	private End[] e = new End[2];
	private int id;
	private Path path;

	public Tag(int id) {
		this.id = id;
	}
	
	public void setEnds(End e1, End e2) {
		this.e[0] = e1;
		this.e[1] = e2;
	}
	
	/*
	 * Creates a new path with the current tag.
	 */
	public Path createNewPath() {
		this.path = new Path(this);
		return path;
	}
	
	public boolean equals(Tag t) {
		return (id == t.id);
	}
	
	public int getTagId() {
		return id;
	}

	public End[] getEnds() {
		return e;
	}

}
