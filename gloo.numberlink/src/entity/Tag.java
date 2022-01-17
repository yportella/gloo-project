package entity;

public class Tag {
	
	private End e1;
	private End e2;
	private int id;
	private Path path;

	public Tag(int id) {
		this.id = id;
	}
	
	public void setEnds(End e1, End e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public Path createNewPath() {
		Path path = new Path(this);
		this.path = path;
		return path;
	}
	
	public boolean equals(Tag t) {
		return (id == t.id);
	}
	
	public void TagString() {
		System.out.println(id);
	}

}
