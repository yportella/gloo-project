package control;

import entity.Grid;
import entity.Path;

import java.util.Arrays;

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
		boolean adv = currentPath.advance(direction); 
		if (!adv){
			System.out.println("On ne peut pas avancer");
		}
		boolean res = grid.isFinished();
		if (res) {
			System.out.println("Gagné !");
		} else {
			System.out.println("Pas encore gagné !");
		}
		grid.GridString();
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
	    return 6;
	    }

	@Override
	public int[] getStartPathPosition( int tag ) {
	    return switch( tag ) {
	        case 0 -> new int[] { 0, 0 };
	        case 1 -> new int[] { 5, 0 };
	        case 2 -> new int[] { 1, 2 };
	        case 3 -> new int[] { 4, 1 };
	        case 4 -> new int[] { 4, 2 };
	        case 5 -> new int[] { 2, 2 };
	        default -> null;
	        };
	    }

	@Override
	public int[] getSecondEndPosition( int tag ) {
	    return switch( tag ) {
	        case 0 -> new int[] { 4, 0 };
	        case 1 -> new int[] { 4, 4 };
	        case 2 -> new int[] { 2, 3 };
	        case 3 -> new int[] { 3, 2 };
	        case 4 -> new int[] { 1, 4 };
	        case 5 -> new int[] { 5, 5 };
	        default -> null;
	        };
	    }

	@Override
	public Direction[] getDirections( int tag ) {
	    return grid.getDirections(tag);
	}

}
