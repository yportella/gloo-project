package control;

public class Controller implements IController {
	
	private Grid grid;
	private Path currentPath;
	
	@Override
	public boolean clickCell(int line, int column) {
		try {
			Path path = grid.createNewPath(line, column);
			currentPath = path;
			return true;
		} catch {
			return false;
		}
	}

	@Override
	public boolean action(Direction direction) {
		currentPath.advance(direction);  
		boolean res = grid.isFinished();
		return res;
    }

}
