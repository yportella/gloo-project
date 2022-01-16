package control;

import entity.Grid;
import entity.Path;
import entity.Direction;

public class Controller implements IController {
	
	private Grid grid;
	private Path currentPath;
	
	public Controller(Grid grid) {
		this.grid = grid;
	}
	
	@Override
	public boolean clickCell(int line, int column) {
		try {
			Path path = grid.createNewPath(line, column);
			currentPath = path;
			return true;
		} catch (Exception e) {
			currentPath = grid.getCellPath(line, column);
			return true;
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
		return grid.getNbLines();
		}

	@Override
	public int getNbColumns() {
	    return grid.getNbColumns();
	    }

	@Override
	public int getNbTags() {
	    return 1;
	    }

	@Override
	public int[] getStartPathPosition( int tag ) {
	    return switch( tag ) {
	        case 0 -> new int[] { 0, 0 };
	        case 1 -> new int[] { 1, 4 };
	        case 2 -> new int[] { 1, 2 };
	        case 3 -> new int[] { 0, 2 };
	        case 4 -> new int[] { 0, 4 };
	        default -> null;
	        };
	    }

	@Override
	public int[] getSecondEndPosition( int tag ) {
	    return switch( tag ) {
	        case 0 -> new int[] { 1, 1 };
	        case 1 -> new int[] { 4, 3 };
	        case 2 -> new int[] { 4, 2 };
	        case 3 -> new int[] { 3, 1 };
	        case 4 -> new int[] { 3, 3 };
	        default -> null;
	        };
	    }

	@Override
	public Direction[] getDirections( int tag ) {
	    return switch( tag ) {
	        case 0 -> new Direction[] {};
	        case 1 -> new Direction[] { Direction.DOWN, Direction.DOWN, Direction.DOWN };
	        case 2 -> new Direction[] { Direction.DOWN, Direction.DOWN };
	        case 3 -> new Direction[] { Direction.LEFT };
	        case 4 -> new Direction[] { Direction.LEFT, Direction.DOWN, Direction.DOWN };
	        default -> null;
	        };
	    }

}
