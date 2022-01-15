package entity;

public class Tag {
	
	private End e1;
	private End e2;
	private int id;

	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public Path createNewPath() {
		Path path = new Path(this);
		return path;
	}
	
	public boolean equals(Tag t) {
		return (id == t.id)
	}

}
