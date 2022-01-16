package control;

import entity.Grid;
import entity.Path;
import entity.Direction;

public class Controller implements IController {
	
	private Grid grid;
	private Path currentPath;
	
	@Override
	public boolean clickCell(int line, int column) {
		try {
			Path path = grid.createNewPath(line, column);
			currentPath = path;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean action(Direction direction) {
		currentPath.advance(direction);  
		boolean res = grid.isFinished();
		return res;
    }

	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbTags() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getStartPathPosition(int tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getSecondEndPosition(int tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Direction[] getDirections(int tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
